import java.util.ArrayList;
import java.util.List;

public class RandomCodeStrategy implements MastermindStrategy{


    private List<int[]> guesses = new ArrayList<>();
    private List<Integer> whitePinsList = new ArrayList<>();
    private List<Integer> orangePinsList = new ArrayList<>();

    private int colors;
    private int turns;
    private int positions;

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
