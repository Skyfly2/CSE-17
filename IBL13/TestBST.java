/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL13
 * Program: TestBST
 */
public class TestBST {
    /**
     * Tests and demonstrates the functionality of the BinaryTree, BinarySearchTree,
     * and Node classes
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        // The instances of Nodes are able to store an Integer data value
        Node root = new Node(12);
        Node left = new Node(4);
        Node right = new Node(23);

        // Instances of nodes can also point to other nodes
        root.left = left;
        root.rigth = right;


        BinaryTree tree = new BinaryTree(root);
        BinaryTree leftTree = new BinaryTree(left);
        BinaryTree rightTree = new BinaryTree(right);

        BinaryTree tree2 = new BinaryTree(root.data, leftTree, rightTree); // tree == tree2
        tree

    }
}