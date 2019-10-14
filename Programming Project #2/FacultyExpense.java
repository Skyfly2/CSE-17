/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: FacultyExpense
 */
public class FacultyExpense extends ExpenseAccount{
    /**
     * Creates a new instance of FacultyExpense with a specified account name and balance
     * @param accountName the name of the account
     * @param balance the balance of the account
     */
    public FacultyExpense(String accountName, double balance){
        super(accountName);
        this.setBalance(balance);
    }
    
    /**
     * Prints an invoice summarizing the charges submitted
     * @param firstLastName the firstLastName
     * @Override
     */
    public void printInvoice(String firstLastName) throws UnknownAccountException, AccountDepletedException{
        
    }
}