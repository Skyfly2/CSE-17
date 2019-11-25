/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified by Asher Hamrick
 * Homework Assignment #8
 * Program: QuickSort
 */
public class QuickSort {
    /**
     * Times the runtime of a QuickSort
     * 
     * @param list the list to be sorted
     * @return the runtime
     */
    public long run(int[] list) {
        long start = System.nanoTime();
        quickSort(list);
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Run quicksort on a list
     * 
     * @param list the list to be sorted
     */
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    /**
     * Quick sort a sublist starting from first and ending with last
     * 
     * @param list  the list to be sorted
     * @param first the first index of the list to be sorted
     * @param last  the end of the list to be sorted
     */
    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Determines the pivot index for a quicksort
     * 
     * @param list  the list to get a pivot index from
     * @param first the first index
     * @param last  the last index
     * @return
     */
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
}