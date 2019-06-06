package common;

public class Util
{
    public static int gcd(int n, int m)
    {
        int tmp = 0;
        if (n < m)
        {
            tmp = n;
            n = m;
            m = tmp;
        }

        while (n % m != 0)
        {
            tmp = n % m;
            n = m;
            m = tmp;
        }

        return m;
    }
}
