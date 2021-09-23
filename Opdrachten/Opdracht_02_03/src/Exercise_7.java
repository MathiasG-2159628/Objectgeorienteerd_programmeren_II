import java.util.Random;

public class Exercise_7 {

    public static void main(String[] args){
        Random r = new Random();
        for (int i=1; i<=25; i++){
            System.out.println(i + "\n");
            int getal1 = r.nextInt();
            int getal2 = r.nextInt();
            System.out.printf("Getal 1: %d \n Getal 2: %d \n", getal1, getal2);
            if (getal1>getal2) System.out.println("Eerste getal is groter \n");
            else if (getal1<getal2) System.out.println("Tweede getal is groter \n");
            else System.out.println("De getallen zijn gelijk \n");
        }
    }
}
