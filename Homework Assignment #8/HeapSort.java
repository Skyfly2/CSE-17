
/*
 * CSE 17 Fall 2019
 * @author Arielle Carr Modified by Asher Hamrick
 * Homework Assignment #8
 * Program: HeapSort
 */
import java.util.*;

/** This class demonstrates heap sort. */
public class HeapSort {

    /**
     * Times the runtime of a HeapSortSort
     * 
     * @param list the list to be sorted
     * @return the runtime
     */
    public long run(int[] list) {
        long start = System.nanoTime();
        heapSort(list);
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Sorts a list by using a heapsort
     * 
     * @param list the list to be sorted
     */
    public static void heapSort(int[] list) {

        // Create a heap to store and organize the values. */
        Heap<Integer> heap = new Heap<Integer>();

        // add all elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // remove the elements from the heap and add to list, from right to left
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}

/**
 * A heap data structure. Contains operations to add and remove from the heap,
 * as well as check its size.
 * 
 * @author Arielle Carr modified by Asher Hamrick
 */
class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<E>();

    /**
     * Creates new instance of heap
     */
    public Heap() {
    }

    /**
     * Create a heap from an array of objects.
     * 
     * @param objects the array to add to the heap
     */
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new object to the heap.
     * 
     * @param newObject the object to be added to the heap
     */
    public void add(E newObject) {
        list.add(newObject); // put at end of the heap
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // swap if current object is greater than its parent
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break; // tree is now a heap
            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap.
     * 
     * @return the removed root
     */
    public E remove() {
        if (list.size() == 0)
            return null;

        E removedObject = list.get(0);
        // set root to last object
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // find the max of the two children (if they exist)
            if (leftChildIndex >= list.size())
                break; // tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // swap if the current node is less than the max
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break; // tree is a heap;
        }
        return removedObject;
    }

    /**
     * Get the size of the heap
     * 
     * @return the number of elements in the heap
     */
    public int getSize() {
        return list.size();
    }
}