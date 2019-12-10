
/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL13
 * Program: BinaryTree
 */
import java.io.*;

public class BinaryTree {

    // Declare instance variables
    protected Node root;

    /**
     * Creates a new instance of a BinaryTree with only one specified Node, as the
     * root
     * 
     * @param root the Node that will be the root of the tree
     */
    protected BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * Creates a new instance of a Binary tree with a given integer value for the
     * root node, and two other trees which will act as the newly created root's
     * left and right subtrees
     * 
     * @param data      the integer value of the root
     * @param leftTree  the tree that will act as the root's left subtree
     * @param rightTree the tree that will act as the root's right subtree
     */
    public BinaryTree(Integer data, BinaryTree leftTree, BinaryTree rightTree) {
        // Build root node with the given Integer data value
        root = new Node(data);

        // Set the left tree of the newly initialized tree
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }

        // Set the right tree of the newly initialized tree
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree of the root of a binary tree
     * 
     * @return the left subtree
     */
    public BinaryTree getLeftSubtree() {
        if (root != null && root.left != null) {
            // Initialize and return a binary tree based upon the root's left child
            return new BinaryTree(root.left);
        } else {
            return null;
        }
    }

    /**
     * Determine of a specific Node is a leaf of a binary tree
     * 
     * @return true if it is a leaf, false if it is not
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

}
