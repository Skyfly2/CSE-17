/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified by Asher Hamrick
 * Homework Assignment #8
 * Program: InsertionSort
 */
/** Implements the insertion sort algorithm. */
public class InsertionSort {

    /**
     * Times the runtime of an InsertionSort
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

    // Note that this is a generic implementation of Insertion sort!
    /**
     * Sort the table using insertion sort algorithm. @pre table contains Comparable
     * objects.
     * 
     * @post table is sorted.
     * @param table The array to be sorted
     */
    public static void sort(int[] table) {
        for (int nextPos = 1; nextPos < table.length; nextPos++) {
            // Insert element at position nextPos
            // in the sorted subarray.
            insert(table, nextPos);
        } // End for.
    } // End sort.

    /**
     * Insert the element at nextPos where it belongs in the array.
     * 
     * @param table   The array being sorted
     * @param nextPos The position of the element to insert
     */
    private static void insert(int[] table, int nextPos) {
        int nextVal = table[nextPos];
        // Element to insert.
        while (nextPos > 0 && nextVal < table[nextPos - 1]) {
            table[nextPos] = table[nextPos - 1];
            // Shift down.
            nextPos--;
            // Check next smaller element.
        }
        // Insert nextVal at nextPos.
        table[nextPos] = nextVal;
    }
}