/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
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
        Node root = new Node(2500);
        Node left = new Node(4);
        Node right = new Node(2800);

        // Instances of nodes can also point to other nodes
        root.left = left;
        root.right = right;
        left.left = new Node(2);
        left.right = new Node(6);

        // Creation of BinaryTrees and how they are connected
        // Standard Tree with a root
        BinaryTree tree = new BinaryTree(root);

        // Two leftSubtrees built in different ways
        BinaryTree leftTree = new BinaryTree(left);
        BinaryTree leftTree2 = tree.getLeftSubtree(); // leftTree == leftTree2

        // Right subtree build with method Nodes
        BinaryTree rightTree = new BinaryTree(right);

        // Build tree other way with subtrees
        BinaryTree tree2 = new BinaryTree(root.data, leftTree, rightTree); // tree == tree2

        // Show whether certain nodes are leaves
        System.out.println("Is the root a leaf? " + tree.isLeaf());
        System.out.println("Is the right subtree a leaf? " + rightTree.isLeaf());

        // Build BinaryTree vs Array of same values
        long treeStartRun, treeEndRun, startRun, endRun;
        long treeRuntime, runtime;
        root = new Node(2500);
        // Initialize Binary Tree
        BinarySearchTree binTree = new BinarySearchTree(root);
        // Initialize Array
        Integer[] arr = new Integer[5000];

        // Add many of the same values to the tree and the array
        for (int c = 0; c < arr.length; c++) {
            if (c / 2 == (double) c / 2.0) {
                arr[c] = c;
                binTree.add(c);
            }
        }

        // Adding values in the middle of data structure
        // Binary tree is much quicker
        treeStartRun = System.nanoTime();
        for (int c = 0; c < arr.length; c++) {
            if (c / 2 != (double) c / 2.0) {
                binTree.add(c);
            }
        }
        treeEndRun = System.nanoTime();
        treeRuntime = treeEndRun - treeStartRun;

        startRun = System.nanoTime();
        // Loop through array and add missing 2500 values, moving each value back as you
        // do so
        for (int c = 0; c < arr.length; c++) {
            if (c / 2 != (double) c / 2.0) {
                int temp = 0;
                Integer last = 0;
                boolean add = false;
                for (int i = 0; i < arr.length; i++) {
                    if (last == null) {
                        break;
                    } else if (arr[i] == null) {
                        temp = last.intValue();
                        last = null;
                        arr[i] = temp;
                    } else if (arr[i] > c && !add) {
                        last = arr[i];
                        arr[i] = c;
                        add = true;
                    } else if (add) {
                        temp = last.intValue();
                        last = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
        endRun = System.nanoTime();
        runtime = endRun - startRun;

        // Display running times
        System.out.println("Running time adding 2500 values to the middle of a BST: " + treeRuntime + " nanoseconds");
        System.out.println("Running time adding 2500 values to the middle of an array: " + runtime + " nanoseconds");

        // Find a specific element in each structure
        // Binary tree is faster because it is able to move through each level, giving
        // it an O(logN) runtime, whereas an array is linear runtime
        treeStartRun = System.nanoTime();
        int found = binTree.find(4222);
        treeEndRun = System.nanoTime();
        treeRuntime = treeEndRun - treeStartRun;

        startRun = System.nanoTime();
        int find = 0;
        // Search for a specific element, pretending the index number wasn't the same as
        // the value
        for (int c = 0; c < arr.length; c++) {
            if (arr[c] == 4222) {
                find = arr[c];
                break;
            }
        }
        endRun = System.nanoTime();
        runtime = endRun - startRun;

        // As number of elements increases, BST will gain more of an advantage
        System.out.println(
                "Running time searching for element 4222 to the middle of a BST: " + treeRuntime + " nanoseconds");
        System.out.println(
                "Running time searching for element 4222 to the middle of an array: " + runtime + " nanoseconds");

        // Delete a specific element in each structure
        // Binary tree is faster because it is able to move through each level, giving
        // it an O(logN) runtime, whereas an array is linear runtime
        treeStartRun = System.nanoTime();
        binTree.delete(1230);
        treeEndRun = System.nanoTime();
        treeRuntime = treeEndRun - treeStartRun;

        startRun = System.nanoTime();
        // Delete a specific element, pretending the index number wasn't the same as
        // the value
        for (int c = 0; c < arr.length; c++) {
            if (arr[c] != null) {
                if (arr[c] == 1230) {
                    for (int i = c; i < arr.length; i++) {
                        if (i + 1 < arr.length) {
                            arr[i] = arr[i + 1].intValue();
                        } else {
                            arr[i] = null;
                        }
                    }
                }
            }
        }
        endRun = System.nanoTime();
        runtime = endRun - startRun;

        // As number of elements increases, BST will gain more of an advantage
        System.out
                .println("Running time deleting element 1230 to the middle of a BST: " + treeRuntime + " nanoseconds");
        System.out.println("Running time deleting element 1230 to the middle of an array: " + runtime + " nanoseconds");

        // Find if each structure contains an element that does exist
        // Binary tree is faster because it is able to move through each level, giving
        // it an O(logN) runtime, whereas an array is linear runtime
        treeStartRun = System.nanoTime();
        boolean con = binTree.contains(3336);
        treeEndRun = System.nanoTime();
        treeRuntime = treeEndRun - treeStartRun;

        startRun = System.nanoTime();
        // Search for element in array, pretending the index number wasn't the same as
        // the value
        found = 0;
        boolean conts = false;
        // Search for 3336
        for (int c = 0; c < arr.length; c++) {
            if (arr[c] == 3336) {
                found = 3336;
                conts = true;
                break;
            }
        }
        endRun = System.nanoTime();
        runtime = endRun - startRun;

        // As number of elements increases, BST will gain more of an advantage
        System.out.println("Running time determining if contains element 3336 in the middle of a BST: " + treeRuntime
                + " nanoseconds");
        System.out.println(con);
        System.out.println("Running time determining if contains element 3336 in the middle of an array: " + runtime
                + " nanoseconds");
        System.out.println(conts);

        // Find if each structure contains an element that does not exist
        // Binary tree is faster because it is able to move through each level, giving
        // it an O(logN) runtime, whereas an array is linear runtime
        treeStartRun = System.nanoTime();
        con = binTree.contains(600000);
        treeEndRun = System.nanoTime();
        treeRuntime = treeEndRun - treeStartRun;

        startRun = System.nanoTime();
        // search for element in array to see if it contains is, pretending the index
        // number wasn't the same as
        // the value
        found = 0;
        conts = false;
        // Search for 600000
        for (int c = 0; c < arr.length; c++) {
            if (arr[c] != null) {
                if (arr[c] == 600000) {
                    found = 600000;
                    conts = true;
                    break;
                }
            }
        }
        endRun = System.nanoTime();
        runtime = endRun - startRun;

        // As number of elements increases, BST will gain more of an advantage
        System.out.println("Running time determining if contains element 600000 in the middle of a BST: " + treeRuntime
                + " nanoseconds");
        System.out.println(con);
        System.out.println("Running time determining if contains element 600000 in the middle of an array: " + runtime
                + " nanoseconds");
        System.out.println(conts);

        System.out.println(
                "For searching for numbers or adding specific numbers to pre-existing data structures, BST's tend to be faster for large amounts of data");
    }

}