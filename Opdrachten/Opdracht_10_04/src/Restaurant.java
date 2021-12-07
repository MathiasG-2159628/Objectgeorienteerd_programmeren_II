import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class Chef implements Runnable {

    @Override
    public synchronized void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //shutdownNow will cause the interruptedexception to be thrown
                e.printStackTrace();
                break;
            }

        }

    }
}

class BusBoy extends Thread{
    @Override
    public synchronized void run() {
        System.out.println("Waiting to clean..");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cleaning...");

    }
}

class Waitperson extends Thread{
    private BusBoy busBoy;

    public Waitperson(BusBoy busBoy){
        this.busBoy = busBoy;
    }

    @Override
    public synchronized void run(){
        try {
            wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (busBoy){
            notifyAll();
        }
    }
}


class App{

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

       /* executorService.execute(new Thread(new Chef()));
        Thread.sleep(3000);
        executorService.shutdownNow();*/

       BusBoy busBoy = new BusBoy();
       Waitperson waitperson = new Waitperson(busBoy);


       executorService.execute(busBoy);
       executorService.execute(waitperson);

    }
}