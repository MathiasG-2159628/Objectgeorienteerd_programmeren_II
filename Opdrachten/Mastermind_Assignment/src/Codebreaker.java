import java.util.ArrayList;
import java.util.List;

/**
 *  This class is an implementation of MastermindStrategy
 *  Its constructor asks a Mastermind game as a parameter to know which colours,
 *  and how many turns and positions it contains
 * @author Mathias Gielen
 **/
public class Codebreaker implements MastermindStrategy {

    private int colors;
    private int turns;
    private int positions;

    private List<int[]> guesses = new ArrayList<>();
    private List<Integer> whitePinsList = new ArrayList<>();
    private List<Integer> orangePinsList = new ArrayList<>();

    /**
     * @param game != null
     */
    public Codebreaker(MastermindGame game){
        colors = game.getColors();
        turns = game.getTurns();
        positions = game.getPositions();
    }

    public int getColors() {
        return colors;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }


    @Override
    public int[] Guess(int whitePins, int orangePins) {
        int[] code=new int[positions];
        if(whitePins == 0 && orangePins == 0){
            for(int i=0;i<positions;i++) {
                code[i] = (int) (Math.random() * colors + 1);
            }
        }else{
            //Can't wrap my head around it so I return a random choice of colors instead

            for(int i=0;i<positions;i++) {
                code[i] = (int) (Math.random() * colors + 1);
            }
            //What SHOULD happen, is generating new choiced based off the white and orange pins from previous choices
        }
        guesses.add(code);
        whitePinsList.add(whitePins);
        orangePinsList.add(orangePins);
        return code;
    }
}
