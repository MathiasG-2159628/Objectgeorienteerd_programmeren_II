public class InvalidColorException extends Exception {
    @Override
    public String getMessage(){
        return "Specified color is not part of this game";
    }
}
