/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL4
 * Program: WordWrapper
 */
import java.util.*;
import java.io.*;
/**
 * Given a source file and target file, break the file into lines no longer than 50 characters each, such that only words 
 * longer than 50 characters are split across line, and writes it back to the target file
 */
public class WordWrapper{
    public final static int LINE_MAX = 50;
    
    public static void main(String args[]) throws Exception{
        if(args.length != 2){
            System.out.println("Usage: java WordWrapper source target");
            System.exit(1);
        }
        
        
        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        Scanner scan = new Scanner(sourceFile);
        PrintWriter output = new PrintWriter(targetFile);
        
        while(scan.hasNextLine()){
            String inLine = scan.nextLine();
            wrapOneLine(inLine, output);
        }
        
        scan.close();
        output.close();
    }
    
    public static void wrapOneLine(String inLine, PrintWriter output){
        for(int c=0; c<inLine.length(); c+=50){
            if(c+50 <= inLine.length()){
                output.println(inLine.substring(c, c+50));
            }
            else{
                output.println(inLine.substring(c, inLine.length()));
            }
        }
    }
}