package net.test.chapter17_containerDepthStudy;

import java.util.*;
import static net.test.util.Print.*;

public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a)
    {
        print("a:" + a);
        a.add(1, "x");
        print("a.add(1, \"x\"):" + a);
        a.add("x");
        print("a.add(\"x\"):" + a);

        a.addAll(Countries.names(25));
        print("a.addAll(Coutries.names(25)):" + a);
        a.addAll(3, Countries.names(25));
        print("a.addAll(3, Coutries.names(25)):" + a);

        b = a.contains("1");
        print("a.contains(\"1\"):" + b);
        b = a.containsAll(Countries.names(25));
        print("a.containsAll(Countries.names(25)):" + b);
        s = a.get(1);
        print("a.get(1):" + s);
        i = a.indexOf("1");
        print("a.indexOf(\"1\"):" + i);
        b = a.isEmpty();
        print("a.isEmpty():" + b);
        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("1");
        print("a.lastIndexOf(\"1\"):" + i);
        a.remove(1);
        print("a.remove(1):" + a);
        a.remove("3");
        print("a.remove(\"3\"):" + a);
        a.set(1, "y");
        print("a.set(1, \"y\"):" + a);
        a.retainAll(Countries.names(25));
        print("a.retainAll(Countries.names(25)): " + a);
        a.removeAll(Countries.names(25));
        print("a.removeAll(Countries.names(25)): " + a);
        i = a.size();
        print("i:" + i);
        a.clear();
    }

    public static void iterMotion(List<String> a)
    {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a)
    {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        it.next();
        it.remove();
        it.next();
        it.set("47");
    }

    public static void testVisual(List<String> a)
    {
        print(a);
        List<String> b = Countries.names(25);
        print("b = " + b);
        a.addAll(b);
        a.addAll(b);
        print(a);

        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        print(a);
        print(x.next());
        x.remove();
        print(x.next());
        x.set("47");
        print(a);
        x = a.listIterator(a.size());
        while (x.hasPrevious())
        {
            printnb(x.previous() + " ");
        }
        print();
        print("testVisual finished");
    }

    public static void testLinkedList()
    {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(Countries.names(25));
        print(ll);
        ll.addFirst("one");
        ll.addLast("two");
        print(ll);
        print(ll.getFirst());
        print(ll.removeFirst());
        print(ll.removeFirst());
        print(ll.removeLast());
        print(ll);
    }

    public static void main(String[] args)
    {
        basicTest(new LinkedList<String>(Countries.names(25)));
        basicTest(new ArrayList<String>(Countries.names(25)));
        iterMotion(new LinkedList<String>(Countries.names(25)));
        iterMotion(new ArrayList<String>(Countries.names(25)));
        iterManipulation(new ArrayList<String>(Countries.names(25)));
        iterManipulation(new LinkedList<String>(Countries.names(25)));
        testVisual(new LinkedList<String>(Countries.names(25)));
        testLinkedList();
    }
}
