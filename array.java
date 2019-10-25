import java.util.*;

public class array {
    public static void main(String[] args) {
        int ints[] = new int[4];
        ints[0] = 5;
        ints[1] = 10;
        ints[3] = 4;
        System.out.println(Arrays.toString(returnArray(ints)));
    }

    public static int[] returnArray(int[] array) {
        return array;
    }
}