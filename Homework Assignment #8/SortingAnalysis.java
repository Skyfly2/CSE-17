
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #8
 * Program: SortingAnalysis
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SortingAnalysis {
        /**
         * Tests the runtime of each major sorting algorithm and creates a txt file with
         * a table of the runtimes for specific circumstances including a randomly
         * sorted array, which it takes the average of 10 runtimes to determine
         * 
         * @param args arguments
         * @throws FileNotFoundException
         */
        public static void main(String[] args) throws FileNotFoundException {
                PrintWriter output = new PrintWriter("SortingStats.txt");

                // Declare and initialize ascending and descending arrays to be tested
                int[] asc = new int[10000];
                int[] desc = new int[10000];
                for (int c = 0; c < asc.length; c++) {
                        asc[c] = c + 1;
                        desc[c] = 15000 - c;
                }

                // Declare and initialize random array
                Random rand = new Random();
                int[] random = new int[10000];
                int[] ran = new int[10000];
                for (int c = 0; c < random.length; c++) {
                        random[c] = rand.nextInt(15000);
                }

                // Clone arrays for reuse
                ran = random.clone();
                int[] desccl = desc.clone();

                // Format output
                output.println("Name of sort:\tWorst Case Runtime:\tBest case runtime:\tRun time(desc):\tRun time(asc):\tRun time(random, average of 10 trials): (Note: Runtimes are in nanoseconds)");

                // Create Sorting objects
                SelectionSort selectionSort = new SelectionSort();
                QuickSort quickSort = new QuickSort();
                MergeSort mergeSort = new MergeSort();
                InsertionSort insertionSort = new InsertionSort();
                BubbleSort bubbleSort = new BubbleSort();
                HeapSort heapSort = new HeapSort();

                // Test Selection sort with 10 trials averaged for random array:
                double runasc = selectionSort.run(asc);
                double rundesc = selectionSort.run(desc);
                double runrand = selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                random = ran.clone();
                runrand += selectionSort.run(random);
                runrand /= 10;
                random = ran.clone();
                desc = desccl.clone();
                output.println("Selection Sort\tO(N^2)\t\t\t\tO(N^2)\t\t\t\t" + rundesc + "\t\t\t" + runasc + "\t\t\t"
                                + runrand);

                // Test Insertion sort with 10 trials averaged for random array:
                runasc = insertionSort.run(asc);
                rundesc = insertionSort.run(desc);
                runrand = insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                random = ran.clone();
                runrand += insertionSort.run(random);
                runrand /= 10;
                random = ran.clone();
                desc = desccl.clone();
                output.println("Insertion Sort\tO(N^2)\t\t\t\tO(N)\t\t\t\t" + rundesc + "\t\t\t" + runasc + "\t\t\t"
                                + runrand);

                // Test Bubble sort with 10 trials averaged for random array:
                runasc = bubbleSort.run(asc);
                rundesc = bubbleSort.run(desc);
                runrand = bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                random = ran.clone();
                runrand += bubbleSort.run(random);
                runrand /= 10;
                random = ran.clone();
                desc = desccl.clone();
                output.println("Bubble Sort\t\tO(N^2)\t\t\t\tO(N)\t\t\t\t" + rundesc + "\t\t\t" + runasc + "\t\t\t"
                                + runrand);

                // Test Merge sort with 10 trials averaged for random array:
                runasc = mergeSort.run(asc);
                rundesc = mergeSort.run(desc);
                runrand = mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                random = ran.clone();
                runrand += mergeSort.run(random);
                runrand /= 10;
                random = ran.clone();
                desc = desccl.clone();
                output.println("Merge Sort\t\tO(Nlog(N))\t\t\tO(Nlog(N))\t\t\t" + rundesc + "\t\t\t" + runasc + "\t\t\t"
                                + runrand);

                // Test Quick sort with 10 trials averaged for random array:
                runasc = quickSort.run(asc);
                rundesc = quickSort.run(desc);
                runrand = quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                random = ran.clone();
                runrand += quickSort.run(random);
                runrand /= 10;
                random = ran.clone();
                desc = desccl.clone();
                output.println("Quick Sort\t\tO(N^2)\t\t\t\tO(Nlog(N))\t\t\t" + rundesc + "\t\t\t" + runasc + "\t\t\t"
                                + runrand);

                // Test Heap sort with 10 trials averaged for random array:
                runasc = heapSort.run(asc);
                rundesc = heapSort.run(desc);
                runrand = heapSort.run(random);
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                random = ran.clone();
                runrand += heapSort.run(random);
                runrand /= 10;
                output.println("Heap Sort\t\tO(Nlog(N))\t\t\tO(Nlog(N))\t\t\t" + rundesc + "\t\t\t" + runasc + "\t\t\t"
                                + runrand);

                output.close();
        }
}