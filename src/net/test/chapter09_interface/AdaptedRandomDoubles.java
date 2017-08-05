package net.test.chapter09_interface;

import java.nio.CharBuffer;
import java.util.Scanner;
import static net.test.util.Print.*;

public class AdaptedRandomDoubles extends RandomDoubles implements Readable {
    private int  count;

    public AdaptedRandomDoubles(int count) {this.count = count;}

    public int read(CharBuffer cb)
    {
        if (count-- == 0) return -1;

        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(new AdaptedRandomDoubles(7));
        while (scanner.hasNextDouble())
        {
            print(scanner.nextDouble());
        }

    }
}
