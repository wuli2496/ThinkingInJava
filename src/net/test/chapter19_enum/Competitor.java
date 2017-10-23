package net.test.chapter19_enum;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
