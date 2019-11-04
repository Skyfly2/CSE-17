
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #6
 * Program: PermutationsK
 */
import java.util.*;

public class PermutationsK {
    static List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    static int count = 0;

    /**
     * Run the recursive PermutationsK method
     * 
     * @param args arguments
     */
    public static void main(String[] args) throws IllegalArgumentException, InputMismatchException {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int k = 0;
        try {
            // Input
            System.out.println("Number of letters to permutate: ");
            num = scan.nextInt();
            if (num > 26 || num < 1) {
                throw new IllegalArgumentException();
            }
            System.out.println("Value of K: ");
            k = scan.nextInt();
            if (k > 26 || k < 0) {
                throw new IllegalArgumentException();
            }
            // Create ArrayList of characters to be used
            ArrayList<String> alph = new ArrayList<>();
            for (int c = 0; c < num; c++) {
                alph.add(alphabet.get(c));
            }
            // Call recursive method
            int numofpermutations = permute(alph, k, "");
            System.out.println("There are " + numofpermutations + " different permutations");
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a number between and including 1 and 26.");
        }
    }

    /**
     * Count and print the permutations of a specified number with k elements used
     * 
     * @param alph   the set of characters to be used
     * @param k      the number of characters in each permutation
     * @param result the resultant string
     * @return count the number of permutations
     */
    public static int permute(ArrayList<String> alph, int k, String result) {
        if (alph.size() > 1 && result.length() < k) {
            for (int c = 0; c < alph.size(); c++) {
                // Store character
                String beg = alph.get(c);
                // Store result
                String oldresult = result;
                // Update result
                result = result + beg;
                // Remove letter for later recursive passes
                alph.remove(beg);
                // recursive call
                permute(alph, k, result);
                // add letter back for later passes
                alph.add(c, beg);
                result = oldresult;
            }
        } else {
            count++;
            // Print result
            System.out.println(result);
        }
        return count;
    }
}