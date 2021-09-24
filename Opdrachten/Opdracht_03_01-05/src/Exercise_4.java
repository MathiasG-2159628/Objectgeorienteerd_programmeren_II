import java.util.Date;

public class Exercise_4 {
    public static void main(String[] args) {
        try{
             Object o = null;
             o.getClass();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
