import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> cls = Class.forName("SecretClass");
        Method methods[] = cls.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(m);
        }
    }
}
