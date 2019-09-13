/** Homework Assignment 1
 * 9/6/2019
@author Asher Hamrick*/
import java.util.*;
public class Clippy{
    public static void main (String [] args){
        Scanner scnr = new Scanner(System.in);
        clippyMenu(scnr, writeDocument(scnr));
    }

    public static String writeDocument(Scanner scnr){
        //Prompt user for input
        System.out.print("Please enter your text: ");
        //Collect input
        String input = scnr.nextLine();
        System.out.println("You entered: " + input);
        return input;
    }

    public static void clippyMenu(Scanner scnr, String userString){
        String select;
        //Provide menu continuosly for the user unless they choose to quit
        while(true){
            System.out.println("Clippy Feature Selection\nnwc - Number of non-whitespace characters\nwc - Number of all characters\nw - Number of words\nf - Find text\nr - Replace text\nq - Quit\n\nSelect an option:");
            //Gather menu input
            select = scnr.nextLine();
            //Select proper method based off of user input
            if(select.equals("nwc")){
                System.out.println("The number of non-whitespace characters: " + numNonwhitespaceChar(userString));
            }  
            else if(select.equals("wc")){
                System.out.println("The total number of characters in the string: " + numAllChar(userString));
            }
            else if(select.equals("w")){
                System.out.println("The number of words in the string: " + numWords(userString));
            }
            else if(select.equals("f")){
                //Prompt user to gain correct parameters for findText method
                System.out.println("Enter the string that you would like to search for: ");
                String find = scnr.nextLine();
                if(findText(userString, find)){
                    System.out.println("The string you are looking for has been found within the text.");
                }
                else{
                    System.out.println("The string you are looking for could not be found within the text.");
                }
            }
            else if(select.equals("r")){
                String find;
                System.out.println("Enter the part of the string you would like to replace: ");
                find = scnr.nextLine();
                System.out.println("Enter what you would like to replace it with: ");
                String replace = scnr.nextLine();
                System.out.println("Here is your updated String: " + replaceText(userString, find, replace));
            }
            else if(select.equals("q")){
                //break out of continuos menu loop if the user chooses to and confirms quitting
                if(quit(scnr)){
                    break;
                }
            }
            else{
                System.out.println("The option you selected does not exist, please try selecting one of the listed options."); 
            }
        }      
    }

    public static int numNonwhitespaceChar (String userString){
        int nwc = 0;
        //Loop through the characters within the string
        for(int c = 0; c < userString.length(); c++){
            //If the character is not whitepsace, increase the non whitespace counter by 1
            if(!Character.isWhitespace(userString.charAt(c))){
                nwc++;
            }
        } 
        return nwc;
    }

    public static int numAllChar(String userString){
        //Gather length of the string
        int numchar = userString.length();
        return numchar;
    }

    public static int numWords(String userString){
        int numwords = 0;
        char lastchar = ' ';
        //Loop through the characters in the string
        for(int c = 0; c < userString.length(); c++){
            //If the last character was a space and the current character is not a space, increase word counter
            //Avoids extra words being counted when double spaces occur or there are spaces at the very beginning
            if(Character.isWhitespace(lastchar) && !Character.isWhitespace(userString.charAt(c))){
                numwords++;
            }
            //Set the last character equal to the value of the current character
            lastchar = userString.charAt(c);
        }
        return numwords;
    }

    public static boolean findText(String userString, String findString){
        //Loop through each possible chunk of the text that is the length of the findString
        for(int c = 0; c + (findString.length() - 1) < userString.length(); c++){
            //If a chunk of the text is equal to the findString, return true
            if(findString.equals(userString.substring(c, c + (findString.length())))){              
                return true;
            }
        }
        return false;
    }

    public static String replaceText(String userString, String findString, String replaceString){
        String replaced = userString;
        //If the entered string is found within the text, replace it
        if(findText(userString, findString)){
            replaced = userString.replace(findString, replaceString);
            return replaced;
        }
        //If string is not found, inform user
        System.out.println("\nError: The string that you would like to replace could not be found within the text.\nPlease enter a new string to be replaced.\nThe Text has been printed below for your convenience:");
        return replaced;
    }

    public static boolean quit(Scanner scnr){
        //Prompt user
        System.out.println("Are you sure you want to quit? (y/n)");
        String confirm = scnr.next();
        if(confirm.equals("y")){
            return true;
        }
        else{
            return false;
        }
    }
}