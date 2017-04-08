package net.test.chapter06.example;

import net.test.chapter06.example.subexample.*;
/**
 * Created by John on 2017/4/8.
 */
public class Dinner {
    public static void main(String[] args)
    {
        Cookie x = new Cookie();
        //x.bite(); //因为bite为包访问权限，而Cookie和Dinner不属于同一个包
    }
}
