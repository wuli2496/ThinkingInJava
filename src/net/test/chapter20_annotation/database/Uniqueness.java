package net.test.chapter20_annotation.database;

import java.lang.annotation.ElementType;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
