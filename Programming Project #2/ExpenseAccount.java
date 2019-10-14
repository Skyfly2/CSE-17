/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: ExpenseAccount
 */
public class ExpenseAccount{
    private String accountName;
    private double balance;
    
    /**
     * Creates a new instance of ExpenseAccount with a specified accountname
     * @param accountName the declared name of the account
     */
    public ExpenseAccount(String accountName){
        this.accountName = accountName;
    }
    
    /**
     * Retrieves the current balance of the account
     * @return this.balance the balance of the account
     */
    public double getBalance(){
        return this.balance;
    }
    
    /**
     * Sets the balance of the account
     * @param balance the new balance of the account
     */
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    /**
     * Removes the amount from the account that corresponds with the amount paid
     * @param charge the amount to be deducted from the account
     */
    public void makePayment(double charge){
        this.balance -= charge;
    }
    
    /**
     * Prints an invoice summarizing charges submitted
     */
    public void printInvoice() throws UnknownAccountException, AccountDepletedException{
        
    }
    
    /**
     * Retrieves the name of the account
     * @return this.accountName the name of the account
     */
    public String getAccountName(){
        return this.accountName;
    }
}