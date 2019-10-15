import java.util.*;
import java.io.*;

/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: GraderExpense
 */
public class GraderExpense extends ExpenseAccount {
    /**
     * Creates a new instance of GraderExpense with a specified account name and
     * balance
     * 
     * @param accountName the name of the account
     * @param balance     the balance of the account
     */
    public GraderExpense(String accountName, double balance) {
        super(accountName);
        this.setBalance(balance);
    }

    /**
     * Prints an invoice summarizing the charges submitted
     * 
     * @param firstLastName the firstLastName
     * @Override
     */
    public void printInvoice(Scanner scan, PrintWriter output) {
        output.println("Invoice For: " + this.getAccountName());
        // Loop through file to determine all charges
        while (scan.hasNextLine()) {
            double charge = scan.nextInt();
            try {
                // Make payment and print to output
                this.makePayment(charge);
                output.println("Department Grader Expense Account Was Charged $" + charge);
            } catch (AccountDepletedException ex) {
                output.println(ex.getMessage());
            }
        }
    }
}