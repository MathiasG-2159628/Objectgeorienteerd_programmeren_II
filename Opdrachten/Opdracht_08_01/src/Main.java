import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws  ClassNotFoundException {
        Object object = new Object();
        getClassMethodsByClassName(object.getClass().getName());
    }

    public static void getClassMethodsByClassName(String str) throws ClassNotFoundException{
        Class c = Class.forName(str);
        Method m[] = c.getDeclaredMethods();
        for(int i=0; i<m.length; i++)
            System.out.println(m[i].toString());
    }
}

