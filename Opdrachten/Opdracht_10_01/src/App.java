import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {



    public static void main(String[] args) {



        Runnable run1 = new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    wait();
                    System.out.println("Notification received");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Sending notification");
                synchronized(run1){
                    run1.notifyAll();
                }
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(run1);
        executorService.execute(run2);

    }
}
