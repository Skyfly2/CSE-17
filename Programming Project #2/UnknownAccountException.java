/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #2
 * Program: UnknownAccountException
 */
public class UnknownAccountException extends IllegalArgumentException{
    /**
     * Creates new instance of UnknownAccountException
     */
    public UnknownAccountException(){
        super("Invalid Account");
    }
}