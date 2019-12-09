/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL13
 * Program: Node
 */
public class Node {

    // Declare instance variables
    protected Integer data;

    protected Node left;

    protected Node right;

    /**
     * Creates a new instance of Node with a specified data value
     * 
     * @param data the data value the node will contain
     */
    public Node(Integer data) {
        // Set data value and child nodes
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Returns a useful String representing the an instance of a Node
     * 
     * @return data the data as a String
     */
    public String toString() {
        return data.toString();
    }
}