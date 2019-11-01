
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of letters to permutate: ");
        int num = scan.nextInt();
        ArrayList<String> alph = new ArrayList<>();
        for (int c = 0; c < num; c++) {
            alph.add(alphabet.get(c));
        }
        int numofpermutations = permute(alph, "");
        System.out.println("There are " + numofpermutations + " different permutations");
    }

    public static int permute(ArrayList<String> alph, String result) {
        if (alph.size() > 1) {
            for (int c = 0; c < alph.size(); c++) {
                String beg = alph.get(c);
                String oldresult = result;
                result = result + beg;
                alph.remove(beg);
                permute(alph, result);
                alph.add(c, beg);
                result = oldresult;
            }
        } else {
            count++;
            System.out.println(result + alph.get(0));
        }
        return count;
    }
}