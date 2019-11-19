
/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified By Asher Hamrick
 * IBL11
 * Program: QuickSortMod
 */
import java.util.*;

public class QuickSortMod {
    static int counter = 0;
    static int[] result;
    static Integer pivot = null;

    public static void quickSort(int[] list) {
        quickSortMod(list, 0, list.length - 1);
    }

    /**
     * Sort with quick sort for more then 20 elements and insertion sort for less
     * than 20 elements
     */
    private static void quickSortMod(int[] list, int first, int last) {
        if (last - first <= 20) {
            int[] table = new int[(last - first) + 1];
            if (pivot != null) {
                table = new int[(last - first) + 2];
            }
            int count = 0;
            for (int c = first; c <= last + 1; c++) {
                if (c == last + 1) {
                    if (pivot != null) {
                        table[count] = pivot;
                        count++;
                    }
                } else {
                    table[count] = list[c];
                    count++;
                }
            }
            insertionSort(table);
            for (int c = 0; c < table.length; c++) {
                result[counter] = table[c];
                counter++;
            }

        } else if (last > first) {
            int pivotIndex = partition(list, first, last);
            pivot = list[pivotIndex];
            quickSortMod(list, first, pivotIndex - 1);
            pivot = null;
            quickSortMod(list, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            // look for leftmost element > pivot
            // the <= pivot below is need if there are dupes in list
            while (low <= high && list[low] <= pivot)
                low++;
            // look for rightmost element <= pivot
            while (low <= high && list[high] > pivot)
                high--;
            if (high > low) { // then swap
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        // find where pivot needs to be placed
        while (high > first && list[high] >= pivot)
            high--;
        // swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else
            return first;
    }

    public static void insertionSort(int[] table) {
        for (int nextPos = 1; nextPos < table.length; nextPos++) {
            // Insert element at position nextPos
            // in the sorted subarray.
            insert(table, nextPos);
        } // End for.
    } // End sort.

    private static void insert(int[] table, int nextPos) {
        Integer nextVal = table[nextPos];
        // Element to insert.
        while (nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
            table[nextPos] = table[nextPos - 1];
            // Shift down.
            nextPos--;
            // Check next smaller element.
        }
        // Insert nextVal at nextPos.
        table[nextPos] = nextVal;
    }

    public static void main(String args[]) {
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, -5, 11, 12, 13, 14, -8, 16, 17, 18, 19, 20, 21, 23, 24, -9, 11, 14,
                32, 453, 35643, 36, 35, 36, 646, 35, 254, 4567, 24234, 6456, 23534, 34565, 3456, 56546, 4564, 25345,
                23545, 234543, 2334, 345, 345, 345, 5, 567, 7, 562, 23, 234, 234, 345 };
        result = new int[list.length];
        quickSort(list);
        System.out.println(java.util.Arrays.toString(result));

    }
}