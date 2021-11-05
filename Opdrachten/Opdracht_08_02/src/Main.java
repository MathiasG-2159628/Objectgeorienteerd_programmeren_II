import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("What method to invoke?");
        Scanner scanner  = new Scanner(System.in);
        String input = scanner.next();

        String[] input_split = input.split("\\.");
        Class partypes[] = new Class[1];
        partypes[0] = String.class;

        Class<?> cl = Class.forName(input_split[0] + "." + input_split[1] + "." + input_split[2]);

        Method method = cl.getDeclaredMethod(input_split[3], partypes);
        Method tostringmethod = cl.getDeclaredMethod("toString",null );
        int paramCount = method.getParameterCount();

        System.out.println("Needs maximum " + paramCount + " parameters. How many will you provide?");
        int paramsToProvide = Integer.parseInt(scanner.next());


        Object arglist[] = new Object[paramsToProvide];
        for(int i = 0; i < paramsToProvide; i++){
            System.out.println("Parameter " + i + 1);
            String parameter = scanner.next();
            arglist[i] = parameter;
        }

        Object obj = cl.newInstance();
        Object result = method.invoke(obj, arglist);
        Object toStringResult = tostringmethod.invoke(obj, null);

        System.out.println("Uitvoering gelukt!");
        System.out.println(toStringResult);
        System.out.println(result);
    }
}
