/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL13
 * Program: BinarySearchTree
 */
public class BinarySearchTree extends BinaryTree {

    // Declare instance variables
    protected boolean addReturn;

    protected Integer deleteReturn;

    /**
     * Creates a new instance of a Binary Search tree with a specified root by
     * calling BinaryTree
     * 
     * @param root the Node that will act as the root of the tree
     */
    public BinarySearchTree(Node root) {
        // Call one argument super class constructor
        super(root);
    }

    /**
     * Add an Integer object to the binary search tree
     * 
     * @param item the Integer object to be added to the binary search tree
     * @return
     */
    public boolean add(Integer item) {
        // Call overloaded add method
        root = add(root, item);
        return addReturn;
    }

    /**
     * Adds a node to a binary tree given a root to add on to
     * 
     * @param localRoot the starting root to attempt to add the data to
     */
    private Node add(Node localRoot, Integer item) {
        if (localRoot == null) {
            // If local root doesn't yet exist, put the node in that spot
            addReturn = true;
            return new Node(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // If data already exists in tree, don't add the data value
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // If data is less than the root, add it to the root to the left of the tree
            // recursively
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // If data is greater than the root, add it to the root to the right of the tree
            // recursively
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Finds an integer within the binary tree
     * 
     * @param target the Integer to be searched for
     * @return
     */
    public Integer find(Integer target) {
        // Call overloaded find method to find the target
        return find(root, target);
    }

    /**
     * Search through the binary tree and find the target
     * 
     * @param localRoot the root to find the target off of
     * @param target    the Integer value being searched for
     * @return
     */
    private Integer find(Node localRoot, Integer target) {
        // Return null if tree doesn't contain target
        if (localRoot == null) {
            return null;
        }
        int compResult = target.compareTo(localRoot.data);
        // If target equals the data of the current node, return the data
        if (compResult == 0) {
            return localRoot.data;
        } else if (compResult < 0) {
            // If target is less than the data, move down to the left subtree
            return find(localRoot.left, target);
        } else {
            // If the target is greater than the data, move down to the right subtree
            return find(localRoot.right, target);
        }
    }

    /**
     * Deletes the node with a certain Integer data value
     * 
     * @param target the Integer value of the data corresponding to the node that
     *               will be deleted
     * @return
     */
    public Integer delete(Integer target) {
        // Call overloaded delete method with root node
        root = delete(root, target);
        return deleteReturn;
    }

    /**
     * Deletes the node with a certain Integer data value
     * 
     * @param localRoot the root of the tree the node will be deleted out of
     * @param item      the Integer that corresponds to the node that will be
     *                  deleted
     * @return
     */
    private Node delete(Node localRoot, Integer item) {
        if (localRoot == null) {
            // Don't delete anything if it isn't set in the first place
            deleteReturn = null;
            return localRoot;
        }

        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {

            // If the target is less than the current data, delete from the left subtree
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {

            // If the target is greater than the current data, delete from the right subtree
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {

            // Return non null root, if one is not null
            if (localRoot.left == null) {

                return localRoot.right;
            } else if (localRoot.right == null) {

                return localRoot.left;
            } else {

                // Edit root data to delete the current value and change it to one of its child,
                // keeping the tree intact
                if (localRoot.left.right == null) {

                    localRoot.data = localRoot.left.data;

                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {

                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**
     * Finds the largest child in a given subtree
     * 
     * @param parent the root of the tree to find the max child of
     * @return
     */
    private Integer findLargestChild(Node parent) {

        // If the right child does not have a right child, the right child is the
        // largest data value
        if (parent.right.right == null) {
            Integer returnValue = parent.right.data;
            // Remove the node from the tree
            parent.right = parent.right.left;
            return returnValue;
        } else {
            // Recursive call down the right side
            return findLargestChild(parent.right);
        }
    }

    /**
     * Determine whether or no not the binary tree contains an intger value
     * 
     * @param elem the integer being searched for
     * @return
     */
    public boolean contains(Integer elem) {
        // Call find method to search for the element
        return elem.equals(find(elem));
    }

}