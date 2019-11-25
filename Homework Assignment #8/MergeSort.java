/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified by Asher Hamrick
 * Homework Assignment #8
 * Program: MergeSort
 */
public class MergeSort {
    /**
     * Times the runtime of a MergeSort
     * 
     * @param list the list to be sorted
     * @return the runtime
     */
    public long run(int[] list) {
        long start = System.nanoTime();
        mergeSort(list);
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Sorts a list by splitting the list until there are many lists of one, and
     * then combining the lists to get a sorted list
     * 
     * @param list the list to be sorted
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // BASE CASE: Merge two sorted arrays of
            // length n/2

            // merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // merge two halves
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * Merge two sorted lists into one sorted list
     * 
     * @param list1 the first list
     * @param list2 the second list
     * @param temp  the list to store the result
     */
    private static void merge(int[] list1, int[] list2, int[] temp) {
        // temp will store the merged list
        // Q: Why don't we have to return temp?
        int current1 = 0; // index in list1
        int current2 = 0; // index in list2
        int current3 = 0; // index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
}