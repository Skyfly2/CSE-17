/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified by Asher Hamrick
 * Homework Assignment #8
 * Program: SelectionSort
 */
/** Implements the selection sort algorithm. */
public class SelectionSort {

    /**
     * Times the runtime of a SelectionSort
     * 
     * @param list the list to be sorted
     * @return the runtime
     */
    public long run(int[] list) {
        long start = System.nanoTime();
        sort(list);
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Sort the array using selection sort algorithm.
     * 
     * @pre table contains Comparable objects.
     * @post table is sorted.
     * @param table The array to be sorted
     */

    public static void sort(int[] table) {
        int n = table.length;
        for (int fill = 0; fill < n - 1; fill++) {
            int posMin = fill;
            for (int next = fill + 1; next < n; next++) {
                if (table[next] < table[posMin]) {
                    posMin = next;
                }
            }
            // Exchange table[fill] and table[posMin].
            int temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;

        }

    }
}