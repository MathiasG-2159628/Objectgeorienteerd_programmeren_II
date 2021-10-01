
public class MastermindApp {
    public static void main(String[] args) {
        MastermindGame game = new MastermindGame();
        MastermindStrategy strategy = new Codebreaker(game);
        game.setStrategy(strategy);
        game.StartGame(false);
    }
}
