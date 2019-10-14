/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: AccountDepletedException
 */
public class AccountDepletedException extends IllegalArgumentException{
    /**
     * Creates new instance of AccountDepletedException
     */
    public AccountDepletedException(){
        super("Insufficient Funds");
    }
}