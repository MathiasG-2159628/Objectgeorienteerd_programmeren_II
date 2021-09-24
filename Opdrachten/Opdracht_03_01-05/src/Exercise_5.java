public class Exercise_5 {

    public static void f() throws NewException2{
        try{
            g();
        }
        catch(NewException1 e){
            throw new NewException2();
        }
    }

    public static void g() throws NewException1{
        throw new NewException1();
    }

    public static void main(String[] args) throws NewException1, NewException2{
        f();
        g();
    }
}

class NewException1 extends Exception{

}

class NewException2 extends Exception{

}