package net.test.chapter15_genericParadigm;

interface SelfBoundedSetter<T extends SelfBoundedSetter<T>>
{
    void set(T arg);
}

interface Setter extends SelfBoundedSetter<Setter>
{
}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundedSetter sbs)
    {
        s1.set(s2);
    }
}
