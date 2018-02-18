import PrimeFactor.PollardRho;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Task01 implements Runnable {
    private CyclicBarrier cyclicBarrier;

    ArrayList<Long> factors = new ArrayList<>();

    public Task01(CyclicBarrier cyclicBarrier, ArrayList<Long> factors) {
        this.cyclicBarrier = cyclicBarrier;
        this.factors = factors;
    }

    public void run() {
        long i = 3;
        long start = System.currentTimeMillis();
        long end = start + 15 * 60 * 1000;
        while (System.currentTimeMillis() < end) {
            while (1 > 0) {
                boolean test = isConsecutive(i);
                if (test) {
                    System.out.println(i);
                    System.out.println("------------");
                    System.out.println(generatePrimSum(i));
                    System.out.println(generatePrimSum(i + 1));
                    System.out.println("------------");

                }
                i++;
            }
        }
    }

    public Long generatePrimSum(long number) {
        PollardRho pollardRho = new PollardRho();
        factors = pollardRho.factorize(number);
        return factors.stream().mapToLong(factor -> factor).sum();
    }

    public boolean isConsecutive(long number) {
        long sum1 = generatePrimSum(number);
        long sum2 = generatePrimSum(number + 1);
        if (sum1 + 1 == sum2) {
            return true;
        }
        return false;
    }
}
