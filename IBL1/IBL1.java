/** IBL1
 * 9/2/2019
@author Asher Hamrick*/
import java.util.Scanner;
public class IBL1{
    public static void main (String [] args){
        Scanner scnr = new Scanner(System.in);
        
        //Prompt for detectWord method
        System.out.print("Enter the string you would you like to search for within the String Array: ");
        String key = scnr.next();
        detectWord(args, key);

        containsNumber(args);

        readWrite(scnr);

        //Prompt for alphaOrder method
        System.out.println("Enter the two strings you want to be placed in alphabetical order: ");
        String[] alphabetize= new String[2];
        System.out.println("Enter the first string: ");
        alphabetize[0] = scnr.nextLine();
        System.out.println("Enter the second string: ");
        alphabetize[1] = scnr.nextLine();
        alphaOrder(alphabetize);

        nameGame(scnr);
    }

    public static void detectWord(String[] stringArr, String key){     
        boolean contain = false;
        //Loop through the strings within the string array
        for(int count = 0; count < stringArr.length; count++){
            //Check string to see if it matches the key word
            if(stringArr[count].equals(key)){
                System.out.println("The string array does contain the indicated word at index " + count + "!");
                contain = true;
            }
            //If the string is not in the array, notify the user
            if((count == stringArr.length - 1) && !contain){
                System.out.println("The string array does not contain the indicated word!");
            }
        }
    }

    public static void containsNumber(String[] stringArr){       
        //Loop through the strings in the string array
        for(int count1 = 0; count1 < stringArr.length; count1++){
            //Loop through the characters in each string in the string array
            for(int count2 = 0; count2 < stringArr[count1].length(); count2++){
                //Check to see if character is a numerical digit
                if(Character.isDigit(stringArr[count1].charAt(count2))){
                    System.out.println("String of index " + count1 + " does contain a numeric digit!");
                    break;
                }
                //Notify user that that particular string does not contain a numerical digit
                if(count2 == (stringArr[count1].length() - 1)){
                    System.out.println("String of index " + count1 + " does not contain a numeric digit!");
                }
            }
        }
    }

    public static void readWrite(Scanner scnr){
        String input;
        boolean haswhitespace = false;
        int count1 = 0;
        while(true){
            System.out.println("Enter a string containing at least one whitespace character: ");
            //On the first attempt have the scanner retreive the next line so that this method is not skipped. Not needed for subsequent attempts
            if(count1 == 0){
                scnr.nextLine();
            }
            //Gather the input
            input = scnr.nextLine();
            //Loop through each character in the user-entered string
            for(int count2 = 0; count2 < input.length(); count2++){
                //Determine if string contains whitespace
                if(Character.isWhitespace(input.charAt(count2))){
                    haswhitespace = true;
                    break;
                }
                //Error message if string doesn't have whitespace
                if(count2 == (input.length() - 1)){
                    System.out.println("The string must have at least one whitespace character!");
                }
            }
            //Exit prompt if criteria is met
            if(haswhitespace){
                break;
            }
            count1++;
        }
        //Remove whitespace from the string
        String complete = input.replace(" ", "");
        System.out.println("Your strings without any whitespace:\n" + complete);
    }

    public static String[] alphaOrder(String[] stringArr){
        String end;
        //Check to see which string has the larger numerical value and concatenate them accordingly to be in alphabetical order
        if(stringArr[0].compareTo(stringArr[1]) > 0){
            end = stringArr[1].concat(stringArr[0]);
            System.out.println(end);
        }
        if(stringArr[1].compareTo(stringArr[0]) > 0){
            end = stringArr[0].concat(stringArr[1]);
            System.out.println(end);
        }
        return stringArr;
    }

    public static void nameGame(Scanner scnr){
        String input;
        String replace = "Banana-fana fo-f";
        //Prompt the user
        System.out.print("Enter a name: ");
        input = scnr.next();
        //Print the concatenated string
        System.out.println(replace.concat(input.substring(1)));
    }
}