import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Application {
    private CyclicBarrier cyclicBarrier;
    ArrayList<Long> factors = new ArrayList<>();

    public Application() {
        cyclicBarrier = new CyclicBarrier(2);
    }


    public void execute() {
        Thread task01 = new Thread(new Task01(cyclicBarrier,factors));

        task01.start();

        try {
            task01.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String... args) {
        Application application = new Application();
        application.execute();
    }
}
