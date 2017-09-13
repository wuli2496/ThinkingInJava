package net.test.chapter16_array;

import java.util.*;
import static net.test.util.Print.*;

public class MultidimensionObjectArrays {
    public static void main(String[] args)
    {
        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere()}
        };

        print(Arrays.deepToString(spheres));
    }
}
