/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL6
 * Program: ExceptionIBL
 */
import java.util.*;
import java.io.*;
public class ExceptionIBL{
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        
        try{
            scan = new Scanner(file);
        }
        catch(FileNotFoundException ex){
            System.out.println("The file was unable to be located");
        }
        
        PrintWriter output = new PrintWriter("Output.txt");
        int val = 0;
        
        try{
            val = value(scan);
            output.println("The integer " + val + " has been found.");
        }
        catch(NoIntFoundException ex){
            output.println(ex.getMessage());
        }
        catch(IllegalArgumentException ex){
            output.println(ex.getMessage());
        }
        finally{
            output.close();
            scan.close();
        }
    }

    public static int value(Scanner scan) throws NoIntFoundException, IllegalArgumentException{
        String input = scan.nextLine();
        int value = 0;
        //Loop through the characters of the input
        for(int c = 0; c < input.length(); c++){
            //Set value equal to the integer if the character is an integer
            if(Character.isDigit(input.charAt(c))){
                value = Character.getNumericValue(input.charAt(c));
                break;
            }
            //Throw exception if character is special character
            if(input.charAt(c) == '!' || input.charAt(c) == '"' || input.charAt(c) == '#' || input.charAt(c) == '$' || input.charAt(c) == '%' || input.charAt(c) == ',' || input.charAt(c) == '(' || input.charAt(c) == ')' || input.charAt(c) == '*' || input.charAt(c) == '+'){
                throw new IllegalArgumentException("Your file contains a special character.");
            }
            //Throw exception if end is reached and no int is found
            if(c == input.length() - 1){
                throw new NoIntFoundException();
            }
        }
        return value;
    }
}

class NoIntFoundException extends IllegalArgumentException{
    public NoIntFoundException(){
        super("Your file contains no integers.");
    }
}