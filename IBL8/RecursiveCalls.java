
public class RecursiveCalls {
    public static void backwardsAlphabet(char currentLetter) {
        if (currentLetter == 'a') {
            System.out.println(currentLetter);
        } else {
            System.out.println(currentLetter + " ");
            backwardsAlphabet(--currentLetter);
        }
    }

    public static void main(String[] args) {
        char startingLetter = 'z';
        backwardsAlphabet(startingLetter);
    }
}