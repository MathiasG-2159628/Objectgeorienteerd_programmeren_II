public class NoStrategyException extends Exception {
    @Override
    public String getMessage(){
        return "No strategy provided to the game";
    }
}
