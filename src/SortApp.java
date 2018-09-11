import utils.ArraySorter;

import java.util.Arrays;

public class SortApp {

    public static void main(String[] args) {

        int[] array = {5, 1, 9, -90, 3, 7, 450, 0, -1};
        System.out.println(Arrays.toString(array));

        try {
            array = ArraySorter.quickSort(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(array));

    }
}
