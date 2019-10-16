import java.util.*;
import java.io.*;

/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: ExpenseAccount
 */
public class ExpenseAccount {
    private String accountName;
    private double balance;

    /**
     * Creates a new instance of ExpenseAccount with a specified accountname
     * 
     * @param accountName the declared name of the account
     */
    public ExpenseAccount(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Retrieves the current balance of the account
     * 
     * @return this.balance the balance of the account
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Sets the balance of the account
     * 
     * @param balance the new balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Removes the amount from the account that corresponds with the amount paid
     * 
     * @param charge the amount to be deducted from the account
     */
    public void makePayment(double charge) throws AccountDepletedException {
        if (this.balance - charge < 0) {
            throw new AccountDepletedException();
        }
        this.balance -= charge;
    }

    /**
     * Prints an invoice summarizing charges submitted
     */
    public void printInvoice(Scanner scan, PrintWriter output) {
        output.println("Invoice For: " + this.getAccountName());
        // Loop through file to determine all charges
        while (scan.hasNextLine()) {
            double charge = scan.nextInt();
            try {
                // Make payment and print to output
                this.makePayment(charge);
                output.print("Department Expense Account Was Charged $");
                output.printf("%.2f", charge);
                output.print("\n");
            } catch (AccountDepletedException ex) {
                output.println(ex.getMessage());
            }
        }
    }

    /**
     * Retrieves the name of the account
     * 
     * @return this.accountName the name of the account
     */
    public String getAccountName() {
        return this.accountName;
    }
}