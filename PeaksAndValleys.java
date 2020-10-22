import java.util.Arrays;
import java.util.Random;
public class PeaksAndValleys {
    public static void main(String[] args){
        int [] array = new int[10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(21) - 10;

        System.out.println("Unsorted Array: " + Arrays.toString(array));
        alternate(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void alternate(int[] array){
        int target;
        for (int i = 0; i < array.length; i = i + 2) {
            target = array[i];
            if (i > 0 && target < array[i - 1]) {
                swap(array, i, i-1);
            }
            if (i < array.length - 1 && target < array[i + 1]) {
                swap(array, i, i+1);
            }
        }
    }

    public static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
