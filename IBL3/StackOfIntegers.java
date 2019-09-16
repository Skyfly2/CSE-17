/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL 3
 * Program: StackOfIntegers
 */
public class StackOfIntegers{
    private int size;
    private int elements[];
    
    /**
     * Creates a new stack of integers with a default capacity of 16
     */
    public StackOfIntegers(){
        this(16);
    }
    
    /**
     * Creates a new stack of integers with the capacity determined by the user
     * @param capacity Declares how large the integer array is
     */
    public StackOfIntegers(int capacity){
        elements = new int[capacity];
        this.size = 0;
    }
    
    /**
     * Determines whether or not any elements have been added to a stack of integers
     * @return true if there are no elements
     * @return false if there are elements
     */
    public boolean empty(){
        if(this.size > 0){
            return false;
        }
        return true;
    }
    
    /**
     * Determines the top element in the stack
     * @return elements[this.size-1] the top element in the stack
     */
    public int peek(){
        if(this.size > 0){
            return elements[this.size-1];
        }
        return -1;
    }
    
    /**
     * Adds a new element to the top of the stack
     * @param value The specific value that will be added
     */
    public void push(int value){
        this.size++;
        elements[this.size - 1] = value;
    }
    
    /**
     * Removes the top element from the stack and returns it
     * @return value the value that is removed from the stack
     */
    public int pop(){
        int value = 0;
        value = elements[this.size - 1];
        elements[this.size - 1] = 0;
        this.size--;
        return value;
    }
    
    /**
     * Determines the size of the stack based off of number of elements
     * return this.size returns the size of the stack
     */
    public int getSize(){
       return this.size;
    }
}