package net.test.chapter15_genericParadigm;

class Cat1 extends ComparablePet implements Comparable<ComparablePet>
{

}

class Hamster extends ComparablePet implements Comparable<ComparablePet>
{

}

class Gecko extends ComparablePet
{

}

public class ComparablePet implements Comparable<ComparablePet>{
    public int compareTo(ComparablePet arg)
    {
        return 0;
    }
}
