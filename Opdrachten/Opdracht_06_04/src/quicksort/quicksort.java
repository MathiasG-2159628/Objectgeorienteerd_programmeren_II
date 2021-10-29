package quicksort;

class Quicksort <T extends Comparable>{

    T[] array;


    public Quicksort(T[] array) {
        this.array = array;
    }

    int partition(int low, int high)
    {

        T pivot = this.array[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {


            if (this.array[j].compareTo(pivot) < 0)
            {
                i++;
                swap(this.array, i, j);
            }
        }
        swap(array, i + 1, high);

        return (i + 1);
    }

    public T[] quickSort(int low, int high)
    {
        if (low < high)
        {

            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
        return array;
    }


    void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class QuicksortApp{

    public static void main(String[] args) {

        Integer[] array = {4, 1, 8, 16, 6, 5, 2};
        Quicksort<Integer> quicksort = new Quicksort(array);

        for(int i : quicksort.quickSort(8, 6)){
            System.out.println(i);
        }
    }

}
