package utils;


public class ArraySorter {


    public static int[] quickSort(int[] array) {
        if (array != null) {
            recQuickSort(array, 0, array.length - 1);
            return array;
        }
        throw new IllegalArgumentException("Array can`t be null");
    }

    private static void recQuickSort(int[] array, int left, int right) {

        if (right - left <= 0) {
            // если левый край зашел за правый (и наоборот) или сравнялся с ним,
            // то сортировать нечего
            return;
        } else {
            // определяем опорный(сравниваемый) элемент
            int pivot = array[right];
            // опредеяем индекс границы разбиения массива
            int bound = partitionIt(array, left, right, pivot);

            // рекурсивный запуск для всех "подмассивов"
            recQuickSort(array, left, bound - 1);
            recQuickSort(array, bound + 1, right);
        }
    }

    private static int partitionIt(int[] array, int left, int right, int pivot) {
        // левый и парвый указатели
        int leftPtr = left - 1; // -1 это запас, поскольку будет использоваться префиксный инкремент
        int rightPtr = right;

        while (true) {
            // идет левый указатель, он будет увеличиваться, пока элемент на соответсвующем индексе меньше
            // опорного элемента
            while (array[++leftPtr] < pivot) ;

            // далее идет правый указатель, он будет уменьшаться пока значение числа на этом
            // указателе больше опорного элемента, либо не дойдет до края массива
            while (rightPtr > 0 && array[--rightPtr] > pivot) ;

            // проверяем, что бы левый индекс не зашел за правый или не сравнялся с ним,
            // если истина то выходим
            if (leftPtr >= rightPtr) {
                break;
                // исли верхнее условие ложно, то меняем между собой значения элементов,
                // на которых остановились указатели
            } else {
                swap(array, leftPtr, rightPtr);
            }


        }
        // меняем между собой элементы на левом указателе и самом правом индексе массива,
        // потому что элемент на левом указателе всегда больше по значению чем pivot или равен ему,
        // значит его сразу можо переместить из половины меньших элементов в половину бОльших
        swap(array, leftPtr, right);

        return leftPtr;
    }


    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
