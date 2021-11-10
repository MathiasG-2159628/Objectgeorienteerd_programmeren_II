public class Consumer extends Thread {

    private Producer producer;

    public Consumer(Producer producer){
       this.producer = producer;
       start();
    }

    @Override
    public synchronized void run() {
        while(true) {
            if (producer.array.size() == 0) {
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int num = producer.array.remove(producer.array.size() - 1);
            System.out.println(factorize(num));

            if(!producer.isAlive() && producer.array.size() == 0){
                break;
            }
        }

    }

    public String factorize(int n) {
        return "idk hoe da moet " + n;
    }
}
