package PrimeFactor;

import java.util.ArrayList;
import java.util.Collections;

public class PollardRho {

    private ArrayList<Long> factors = new ArrayList<>();

    public ArrayList<Long> factorize(long number) {
        long n = number;
        //System.out.print("prime factorization of " + n + " : ");

        for (long i = 2; i * i <= n; i++)
            while (n % i == 0) {
                //System.out.print(i + " ");
                factors.add(i);
                n = n / i;
            }

        if (n > 1) {
            factors.add(n);
            //System.out.println(n);
        }
        else {
            //System.out.println();
        }
        return factors;
    }
}