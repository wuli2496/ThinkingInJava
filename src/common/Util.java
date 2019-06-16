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

    public static int eular(int x)
    {
        int ans = 1;

        for (int i = 2; i * i <= x; ++i)
        {
            if (x % i == 0)
            {
                x = x / i;
                ans *= (i - 1);

                while (x % i == 0)
                {
                    x = x / i;
                    ans *= i;
                }
            }
        }

        if (x > 1)
        {
            ans *= (x - 1);
        }

        return ans;
    }

    public static int hightNBit(double num, int n)
    {
        double lognum = num;
        double decimal = lognum - Math.floor(lognum);

        double ans = Math.pow(10, decimal);

        ans = ans * Math.pow(10, n - 1);

        return (int)ans;
    }
}
