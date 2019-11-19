/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified By Asher Hamrick
 * IBL11
 * Program: MergeSortMod
 */
public class MergeSortMod {
    static int[] result;
    static int counter = 0;

    // Sort with mergesort for greater than 20 elements. sort with selection sort
    // for less than 20
    public static void mergeSortMod(int[] list) {
        if (list.length <= 20) {
            selectionSort(list);
            int[] storeres = new int[counter];
            for (int c = 0; c < counter; c++) {
                storeres[c] = result[c];
            }
            merge(list, storeres, result);
            counter += list.length;
        } else {
            // BASE CASE: Merge two sorted arrays of
            // length n/2

            // merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSortMod(firstHalf);

            // merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSortMod(secondHalf);
        }
    }

    private static void merge(int[] list1, int[] list2, int[] temp) {

        int current1 = 0; // index in list1
        int current2 = 0; // index in list2
        int current3 = 0; // index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else {
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static void selectionSort(int[] table) {
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

    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, -5, 11, 12, 13, 14, -8, 16, 17, 18, 19, 20, 21, 23, 24, -9, 11, 14,
                32, 453, 35643, 36, 35, 36, 646, 35, 254, 4567, 24234, 6456, 23534, 34565, 3456, 56546, 4564, 25345,
                23545, 234543, 2334, 345, 345, 345, 5, 567, 7, 562, 23, 234, 234, 345 };
        result = new int[list.length];
        mergeSortMod(list);
        System.out.println(java.util.Arrays.toString(result));
    }
}