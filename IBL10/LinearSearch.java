
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL10
 * Program: LinearSearch
 */
import java.util.*;

public class LinearSearch<E extends Comparable<E>> {
    E[] vals;

    public LinearSearch(E[] list) {
        vals = list;
    }

    public int search(E key, int start, int end) {
        if (vals[(start + end) / 2].compareTo(key) == 0) {
            return (start + end) / 2;
        } else {
            if (vals[(start + end) / 2].compareTo(key) < 0) {
                return search(key, (start + end) / 2, end);
            } else {
                return search(key, start, (start + end) / 2);
            }
        }
    }
}