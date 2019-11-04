
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #6
 * Program: Combinations
 */
import java.util.*;

public class Combinations {
    static int count = 1;
    static List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    /**
     * Run the combinations method
     * 
     * @param args arguments
     * @throws InputMismatchException
     * @throws IllegalArgumentException
     */
    public static void main(String[] args) throws InputMismatchException, IllegalArgumentException {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        try {
            // Prompt input
            System.out.println("Enter the number of letters you would like to combine:");
            n = scan.nextInt();
            if (n < 1 || n > 26) {
                throw new IllegalArgumentException();
            }
            // Build arraylist of letters to be used
            ArrayList<String> alph = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                alph.add(alphabet.get(c));
            }
            // Run recursive method
            int numofcombinations = combine(alph, 0, alph.size(), "");
            System.out.println("");
            System.out.println("There are " + numofcombinations
                    + " combinations (including the empty String) using the first " + n + " letters");
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a number between and including 1 and 26.");
        }

    }

    /**
     * Count and print the combinations of the input
     * 
     * @param alph   the characters to be used
     * @param index  the starting index for the recursive call
     * @param length the max length of the result
     * @param result the result as a string
     * @return count the number of combinations
     */
    public static int combine(ArrayList<String> alph, int index, int length, String result) {
        if (index >= length) {
            // Because solutions are already printed as they are created, no need to do
            // anything here. Although this should be the end of each recursive call
        } else {
            for (int c = index; c < alph.size(); c++) {
                // Store result for use in next loop through
                String oldresult = result;
                // Add character to result and print
                result = result + alph.get(c);
                System.out.println(result);
                count++;
                // Recursive call adding one to the index as to not repeat letters
                combine(alph, c + 1, length, result);
                result = oldresult;
            }
        }
        return count;
    }
}