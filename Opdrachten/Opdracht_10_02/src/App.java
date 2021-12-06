public class App {

    //Conclusion: busy wait takes longer

    public static void main(String[] args) throws InterruptedException {
        /*Task1 task1 = new Task1();
        Task2 task2 = new Task2(task1);
        task2.start();
        task1.start();*/
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        task3.setThread(task4);
        task4.setThread(task3);
        task3.start();
        task4.start();
    }

}

class Task1 extends Thread{
    public boolean flag = false;

    @Override
    public void run() {
        System.out.println("Task 1 sleeping...");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 1 done sleeping");
        flag = true;
    }
}

class Task2 extends Thread{

    public Task1 thread;
    public Task2(Task1 task1){
        this.thread = task1;
    }

    @Override
    public void run() {
        checkflag();
    }

    public void checkflag(){
        long before = System.currentTimeMillis();
        while(!thread.flag){
            System.out.println("Task 1 waiting...");
        }
        thread.flag = false;
        System.out.println("Time it took:");
        System.out.println(System.currentTimeMillis() - before);

    }
}

class Task3 extends Thread{
    public boolean flag = false;
    public Task4 thread;


    public void setThread(Task4 thread) {
        this.thread = thread;
    }

    @Override
    public synchronized void run() {
        System.out.println("Task 3 sleeping...");
        try {
            wait(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 3 done sleeping");
        flag = true;
        synchronized (thread){
            thread.notify();
        }
    }
}

class Task4 extends Thread{

    public Task3 thread;



    @Override
    public void run() {
        checkflag();
    }

    public void setThread(Task3 thread) {
        this.thread = thread;
    }

    public synchronized void checkflag(){
        long before = System.currentTimeMillis();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.flag = false;
        System.out.println("Time it took:");
        System.out.println(System.currentTimeMillis() - before);

    }
}