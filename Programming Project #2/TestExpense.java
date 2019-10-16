import java.util.*;
import java.io.*;

/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: TestExpense
 */
public class TestExpense {
    /**
     * Test the expense classes
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        // Gather and test to make sure file exists
        try {
            File input = new File(args[0]);
            Scanner scan = new Scanner(input);
            String accountType = scan.next(), first = scan.next(), last = scan.next(), name = first + " " + last;
            PrintWriter output = new PrintWriter("output.txt");
            try {
                // Create Account and print invoice
                ExpenseAccount acc = createAccount(accountType, name);
                acc.setBalance(2000);
                acc.printInvoice(scan, output);
                output.close();
                scan.close();
            } catch (UnknownAccountException ex) {
                // If account doesn't exist, print it
                output.println("Invoice For: " + name);
                output.println(ex.getMessage());
                output.close();
                scan.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file could not be found");
        }
    }

    /**
     * Create a new type of ExpenseAccount
     * 
     * @param accountType
     * @param name
     * @return
     * @throws UnknownAccountException
     */
    public static ExpenseAccount createAccount(String accountType, String name) throws UnknownAccountException {
        // Depending on the type of the account, make the actual type different
        if (accountType.equals("E")) {
            return new ExpenseAccount(name);
        } else if (accountType.equals("G")) {
            return new GraderExpense(name, 2000);
        } else if (accountType.equals("F")) {
            return new FacultyExpense(name, 2000);
        } else {
            throw new UnknownAccountException();
        }
    }
}