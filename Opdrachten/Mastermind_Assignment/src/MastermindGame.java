import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MastermindGame {
    private int colors = 6;
    private int turns = 12;
    private int positions = 4;
    private Codemaker codeMaker;
    private MastermindStrategy strategy;

    public MastermindGame(){
        codeMaker = new Codemaker();
    }

    public void setStrategy(MastermindStrategy strategy) {
        this.strategy = strategy;
    }

    public MastermindGame(int colors, int turns, int positions, MastermindStrategy strategy) {
        this.colors = colors;
        this.turns = turns;
        this.positions = positions;
        codeMaker = new Codemaker();
        this.strategy = strategy;

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

    public void StartGame(boolean isCodebreaker){

        try {
            if (strategy == null) {
                throw new NoStrategyException();
            }

            //This IDE doesn't allow System.console().readLine() - throws nullpointer
            Scanner s = new Scanner(System.in);

            int i = 1;
            boolean codeCracked = false;

            int[] code = new int[getPositions()];
            if (isCodebreaker) {
                code = codeMaker.GenerateColorCode(getColors(), getPositions());
            } else {
                for (int j = 0; j < getPositions(); j++) {
                    try {
                        System.out.printf("Code position %d: \n", j + 1);
                        int color = Integer.parseInt(s.nextLine());
                        if(color > colors || color < 1){
                            throw new InvalidColorException();
                        }
                        else{
                            code[j] = color;
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        j--;
                    }
                }
            }
            int orangePins, whitePins;


            while (i <= getTurns() && codeCracked == false) {
                orangePins = 0;
                whitePins = 0;
                System.out.printf("Attempt %d \n", i);

                System.out.println("Choose a color code");
                int[] chosenColors = new int[getPositions()];
                if (isCodebreaker) {
                    for (int j = 0; j < getPositions(); j++) {
                        try {
                            System.out.printf("Position %d: \n", j + 1);
                            int chosenColor = Integer.parseInt(s.nextLine());
                            if(chosenColor > colors || chosenColor < 1){
                                throw new InvalidColorException();
                            }
                            else{
                                chosenColors[j] = chosenColor;
                            }
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            j--;
                        }
                    }
                } else {
                    chosenColors = strategy.Guess(whitePins, orangePins);
                    for (int j = 0; j < chosenColors.length; j++) {
                        System.out.printf("Position %d: %d \n", j + 1, chosenColors[j]);
                    }
                }

                int[] codeWithoutDuplicates = Arrays.stream(code).distinct().toArray();
                List chosenColorsList = Arrays.stream(chosenColors).boxed().collect(Collectors.toList());

                for (int j = 0; j < codeWithoutDuplicates.length; j++) {
                    if (chosenColorsList.contains(codeWithoutDuplicates[j])) {
                        whitePins++;
                    }
                }

                for (int j = 0; j < code.length; j++) {
                    if (chosenColors[j] == code[j]) {
                        orangePins++;
                        if (whitePins > 0) {
                            whitePins--;
                        }
                    }
                }

                if (orangePins == getPositions()) {
                    codeCracked = true;
                }

                System.out.printf("White pins: %d \n", whitePins);
                System.out.printf("Orange pins: %d \n", orangePins);

                i++;
            }

            if (!codeCracked) System.out.println("The code couldn't be cracked.");
            else System.out.println("The code has been cracked!");

        }catch(NoStrategyException e){
            System.out.println(e.getMessage());
        }
    }
}
