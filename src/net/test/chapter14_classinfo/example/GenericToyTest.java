package net.test.chapter14_classinfo.example;

import javax.xml.stream.FactoryConfigurationError;

/**
 * Created by John on 2017/6/25.
 */
public class GenericToyTest {
    public  static void main(String[] args)
    {
        Class<FancyToy> ftClass = FancyToy.class;
        try {
            FancyToy fancyToy = ftClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Class<? super FancyToy> up = ftClass.getSuperclass();
        try {
            Object obj = up.newInstance();
        } catch (Exception e) {

        }
    }
}
