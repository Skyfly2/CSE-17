/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified by Asher Hamrick
 * Homework Assignment #8
 * Program: BubbleSort
 */
public class BubbleSort {

    /**
     * Times the runtime of a BubbleSort
     * 
     * @param list the list to be sorted
     * @return the runtime
     */
    public long run(int[] list) {
        long start = System.nanoTime();
        bubbleSort(list);
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Sorts a list using a bubble sort
     * 
     * @param list the list to be sorted
     * @return iterations the number of iterations
     */
    public static int bubbleSort(int[] list) {
        int iterations = 0;
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false; // pass not needed until a swap
            // last k-1 elements are already sorted

            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    // swap them
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;

                }

                iterations++;
            }
        }
        return iterations;
    }
}