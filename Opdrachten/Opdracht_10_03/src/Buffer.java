import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Buffer {

    private BlockingQueue<Integer> queue;

    public Buffer(){
        queue = new LinkedBlockingDeque<Integer>();
    }

    public void addValue(int value)
    {
        try {
            queue.put(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getValue() throws InterruptedException
    {
        return queue.take();
    }
}
