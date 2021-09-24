public class Exercise_1 {
    public static void main(String[] args){
        try{
            throw new Exception("Hello");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Exception thrown");
        }
    }
}
