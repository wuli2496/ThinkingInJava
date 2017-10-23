package net.test.chapter19_enum;

import net.test.util.Generator;
import net.test.util.TextFile;

import java.util.EnumMap;
import java.util.Iterator;

import static net.test.chapter19_enum.Input.*;
import static net.test.util.Print.print;

enum Category
{
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values;
    Category(Input... types)
    {
        values = types;
    }

    private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants())
        {
            for (Input type : c.values)
            {
                categories.put(type, c);
            }
        }
    }

    public static Category categorize(Input input)
    {
        return categories.get(input);
    }
}

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT};

    enum State {
        RESTING {
            void next(Input input)
            {
                switch (Category.categorize(input))
                {
                    case MONEY:
                        amount += input.amout();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                }
            }
        },
        ADDING_MONEY {
            void next(Input input)
            {
                switch (Category.categorize(input))
                {
                    case MONEY:
                        amount += input.amout();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amout())
                        {
                            print("Insufficient money for " + selection);
                        }
                        else
                        {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next()
            {
                print("here is your " + selection);
                amount -= selection.amout();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next()
            {
                if (amount > 0)
                {
                    print("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            void output()
            {
                print("Halted");
            }
        };

        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true;}
        void next(Input input)
        {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }

        void next()
        {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSIENT states");
        }

        void output()
        {
            print(amount);
        }
    }

    static void run(Generator<Input> gen)
    {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
            {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args)
    {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1) gen = new FileInputGenerator(args[0]);
        run(gen);
    }
}

class RandomInputGenerator implements Generator<Input>
{
    public Input next()
    {
        return Input.randomSelection();
    }
}

class FileInputGenerator implements Generator<Input>
{
    private Iterator<String> input;
    public FileInputGenerator(String fileName)
    {
        input = new TextFile(fileName, ";").iterator();
    }

    public Input next()
    {
        if (!input.hasNext()) return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
