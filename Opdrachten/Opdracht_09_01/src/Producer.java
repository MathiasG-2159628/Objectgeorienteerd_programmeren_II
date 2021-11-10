import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer extends Thread {
    public List<Integer> array;
    private Random random;

    public Producer(){
        random = new Random();
        array = new ArrayList<>();
        start();
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            array.add(random.nextInt((100000 - 1000) + 1) + 1000);

        }
    }


}
