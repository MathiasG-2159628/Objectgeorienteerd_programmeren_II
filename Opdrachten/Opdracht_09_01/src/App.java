public class App {
    public static void main(String[] args) {
        Producer producer = new Producer();
        new Consumer(producer);
    }
}
