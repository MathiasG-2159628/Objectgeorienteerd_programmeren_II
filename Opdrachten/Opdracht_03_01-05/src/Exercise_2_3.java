public class Exercise_2_3 {
    public static void main(String[] args) {
        try{
            throw new MyException("Argument");
        }catch(MyException e){
            e.printMessage();
        }
    }
}


class MyException extends Exception{
    String message;

    /*
        @arg is not null
    */
    public MyException(String arg){
        this.message= arg;
    }

    public void printMessage(){
        System.out.println(message);
    }

}
