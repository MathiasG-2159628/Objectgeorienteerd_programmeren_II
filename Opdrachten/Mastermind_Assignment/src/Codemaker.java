/**
 * @author Mathias Gielen
 **/
public class Codemaker {
    /**
     * @param colors >= 1
     * @param positions >= 1
     * @return != null
     */
    public int[] GenerateColorCode(int colors, int positions){
        int[] code=new int[positions];

        for(int i=0;i<positions;i++) {
            code[i] = (int) (Math.random() * colors + 1);
        }

        return code;
    }
}
