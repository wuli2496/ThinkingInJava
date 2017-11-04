package net.test.chapter20_annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static net.test.util.Print.*;

public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl)
    {
        for (Method m : cl.getDeclaredMethods())
        {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null)
            {
                print("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCases)
        {
            print("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
