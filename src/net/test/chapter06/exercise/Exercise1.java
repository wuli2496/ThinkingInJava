package net.test.chapter06.exercise;

/**
 * 在引用两个包时，如果两个包中有相同的类，会导致冲突，这时可以引用包名+类名的形式来区分
 */

import net.test.chapter06.example.*;
import java.util.*;
/**
 * Created by John on 2017/4/8.
 */
public class Exercise1 {
    public static void main(String[] args)
    {
        net.test.chapter06.example.Vector v = new net.test.chapter06.example.Vector();
    }
}
