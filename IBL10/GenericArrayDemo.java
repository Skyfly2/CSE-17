import java.util.*;

public class GenericArrayDemo<E extends Comparable<E>> {
    E[] arrayDemo;

    public GenericArrayDemo(E[] input) {
        arrayDemo = input;
    }

    public E[] returnArray() {
        return arrayDemo;
    }

    public static void main(String[] args) {
        Integer[] myArray1 = new Integer[10];
        for (int c = 0; c < myArray1.length; c++) {
            myArray1[c] = c;
        }
        GenericArrayDemo<Integer> demo1 = new GenericArrayDemo<>(myArray1);
        System.out.println(Arrays.toString(demo1.returnArray()));

        Double[] myArray2 = new Double[10];
        for (int c = 0; c < myArray2.length; c++) {
            myArray2[c] = c * Math.PI;
        }
        GenericArrayDemo<Double> demo2 = new GenericArrayDemo<>(myArray2);
        System.out.println(Arrays.toString(demo2.returnArray()));

    }
}