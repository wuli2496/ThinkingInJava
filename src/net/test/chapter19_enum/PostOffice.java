package net.test.chapter19_enum;

import net.test.util.Enums;

import java.util.Iterator;

import static net.test.util.Print.print;

class Mail
{
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5};
    enum Scanability {UNSCANABLE, YES1, YES2, YES3, YES4};
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4};
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6};
    enum ReturnAddress {MISSING, ok1, OK2, OK3, OK4, OK5};

    GeneralDelivery generalDelivery;
    Scanability scanability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;
    public String toString()
    {
        return "Mail " + id;
    }

    public String details()
    {
        return toString() + ", General Delivery: " + generalDelivery +
                ", Address Scanablity: " + scanability +
                ", Address Readability: " + readability +
                ", Address address: " + address +
                ", Return address: " + returnAddress;
    }

    public static Mail randomMail()
    {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scanability = Enums.random(Scanability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);

        return m;
    }

    public static Iterable<Mail> generator(final int count)
    {
        return new Iterable<Mail>() {
            int n = count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                       return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove()
                    {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(Mail m)
            {
                switch (m.generalDelivery)
                {
                    case YES:
                        print("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MECHINE_SCAN {
            boolean handle(Mail m)
            {
                switch (m.scanability)
                {
                    case UNSCANABLE:
                        return false;
                    default:
                        switch(m.address)
                        {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m)
            {
                switch (m.readability)
                {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address)
                        {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " nomally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m)
            {
                switch (m.returnAddress)
                {
                    case MISSING:
                        return false;
                    default:
                        print("Returing " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail m);
    }

    static void handle(Mail m)
    {
        for (MailHandler handler : MailHandler.values())
        {
            if (handler.handle(m))
            {
                return;
            }
        }
        print(m + " is a dead letter");
    }

    public static void main(String[] args)
    {
        for (Mail mail: Mail.generator(10))
        {
            print(mail.details());
            handle(mail);
            print("******");
        }
    }
}
