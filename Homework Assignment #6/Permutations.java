
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #6
 * Program: Permutations
 */
import java.util.*;

public class Permutations {
    static List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    static int count = 0;

    /**
     * Run the permutations recursive method
     * 
     * @param args arguments
     */
    public static void main(String[] args) throws IllegalArgumentException, InputMismatchException {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try {
            // Input
            System.out.println("Number of letters to permutate: ");
            num = scan.nextInt();
            if (num > 26 || num < 1) {
                throw new IllegalArgumentException();
            }
            // Create ArrayList of characters to be used
            ArrayList<String> alph = new ArrayList<>();
            for (int c = 0; c < num; c++) {
                alph.add(alphabet.get(c));
            }
            // Run recursive method
            int numofpermutations = permute(alph, "");
            System.out.println("There are " + numofpermutations + " different permutations");
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a number between and including 1 and 26.");
        }
    }

    /**
     * Count and print all permutations using the given number of of letters
     * 
     * @param alph   the set of characters to be used
     * @param result the resultant string
     * @return count the number of permutations
     */
    public static int permute(ArrayList<String> alph, String result) {
        if (alph.size() > 1) {
            for (int c = 0; c < alph.size(); c++) {
                // Create a string to store the character
                String beg = alph.get(c);
                // Store the result
                String oldresult = result;
                // Update result
                result = result + beg;
                // Remove letter so it is not reused in the same string
                alph.remove(beg);
                // Recursive call
                permute(alph, result);
                // Add letter back for use later
                alph.add(c, beg);
                // reset result
                result = oldresult;
            }
        } else {
            count++;
            // Output result
            System.out.println(result + alph.get(0));
        }
        return count;
    }
}