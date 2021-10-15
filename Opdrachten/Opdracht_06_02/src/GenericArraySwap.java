import com.sun.jdi.InvalidTypeException;

public class GenericArraySwap {

    /**
     *
     * @param array
     * @param i
     * @param j
     * @param <T>
     */
    public static <T> void genericArraySwap(T[] array, int i, int j){
        try {
            T firstElement = array[i];
            T secondElement = array[j];

            array[i] = secondElement;
            array[j] = firstElement;
            for (T element : array) {
                System.out.println(element);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        genericArraySwap(new Integer[] {},2,8);

    }
}
