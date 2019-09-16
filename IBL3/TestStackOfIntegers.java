/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL 3
 * Program: TestStackOfIntegers
 */
import java.util.*;
public class TestStackOfIntegers{
    /**
     * This is a main method used for testing the StackOfIntegers Class
     * @param args[] Arguments
     */
    public static void main(String [] args){
        StackOfIntegers stack1 = new StackOfIntegers();
        System.out.println("stack1 declared with no parameters. Size will default to 16.");
        //See if stack1 is empty
        System.out.println("Is stack1 empty (stack1.empty()): ");
        System.out.println(stack1.empty());
        
        //Add an element to stack1
        System.out.println("Add element (8) to stack1 (stack1.push(8)): ");
        stack1.push(8);
        //View the added element
        System.out.println("View the added element (stack1.peek()): ");
        System.out.println(stack1.peek());
        //Show stack 1 is not empty
        System.out.println("Is stack1 still empty (stack1.empty()):");
        System.out.println(stack1.empty());
        //Add more elements to stack1
        System.out.println("Add more elements to stack1 using stack.push(int a) (3,6,12,9,3)");
        stack1.push(3);
        stack1.push(6);
        stack1.push(12);
        stack1.push(9);
        stack1.push(3);
        //View the final added element
        System.out.println("Check that the final element is 3 (stack1.peek()): ");
        System.out.println(stack1.peek());
        //Find size of stack
        System.out.println("Check the size of the stack (stack1.getSize()): ");
        System.out.println(stack1.getSize());
        //Remove an element
        System.out.println("Remove and return final element from stack (stack1.pop()) : ");
        System.out.println(stack1.pop());
        //Check new final element
        System.out.println("Check new final element (stack1.peek()): ");
        System.out.println(stack1.peek());
        //Check new size
        System.out.println("Check new size of stack (stack1.getSize()): ");
        System.out.println(stack1.getSize());
        
        StackOfIntegers stack2 = new StackOfIntegers(2);
        System.out.println("stack2 declared as \"StackOfIntegers stack2 = new StackOfIntegers(2)\", initializing capacity to 2 ");
        System.out.println("Is stack2 empty (stack2.empty()): ");
        System.out.println(stack2.empty());
    }
}