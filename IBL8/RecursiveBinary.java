/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL8
 * Program: RecursiveBinary
 */
public class RecursiveBinary {
    public static void main(String[] args) {
        int[] myList = { 2, 4, 7, 9, 10, 11, 19, 29, 30 };
        int key = 29;
        System.out.println(binarySearch(myList, key, 0, myList.length - 1));
    }

    public static int binarySearch(int[] list, int key, int low, int high) {
        int mid = (low + high) / 2;

        if (list[mid] == key) {
            return mid;
        } else if (list[mid] > key) {
            return binarySearch(list, key, low, mid);
        } else {
            return binarySearch(list, key, mid, high);
        }
    }
}