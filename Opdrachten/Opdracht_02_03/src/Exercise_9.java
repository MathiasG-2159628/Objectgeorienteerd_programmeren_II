public class Exercise_9 {
    public static void main(String[] args) {
        for(int i = 1; i < 1000; i++){
            boolean isPriem = true;
            for(int j = 2; j < i; j++){
                if (i <= 1) isPriem = false;
                if (i % j == 0) isPriem = false;
            }
            if(isPriem) System.out.println(i);
        }
    }
}
