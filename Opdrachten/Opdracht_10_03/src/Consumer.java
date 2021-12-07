public class Consumer extends Thread{

    private int consumedValue = 0;
    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run()
    {

        while(true){
            try {
                consumedValue = buffer.getValue();
                System.out.println("Consumed value: " + consumedValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
