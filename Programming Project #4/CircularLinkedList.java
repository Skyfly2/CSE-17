/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL12
 * Program: CircularLinkedList
 */
public class CircularLinkedList {
    public Node head;
    public int size;

    /**
     * Create new instance of CircularLinkedList
     */
    public CircularLinkedList() {
        head = null;
    }

    /**
     * Adds node as the new head of the data
     * 
     * @param data the data value of the node
     */
    public void addStart(int data) {
        if (size == 0) {
            // Build head
            Node first = new Node(data);
            head = first;
            head.next = head;
        } else {
            // Build new node represented by the head and have the new head point to it
            Node newNode = new Node(head.data);
            head.data = data;
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    /**
     * Add new node to the end of the linkedlist
     * 
     * @param data the data value of the node
     */
    public void addEnd(int data) {
        // Reuse other code for same application
        if (head == null) {
            addStart(data);
        } else {
            // Build new node with data
            Node n = new Node(data);
            Node currNode = head;

            // Loop through list and add node to the end
            while (currNode.next != head) {
                currNode = currNode.next;
            }
            // Update nodes
            currNode.next = n;
            n.next = head;
            size++;
        }
    }

    /**
     * Delete the first node from the linked list
     * 
     * @return data the deleted data
     */
    public int deleteStart() {
        // Delete head if it is the only thing
        if (head.next == head) {
            int data = head.data;
            head = null;
            size--;
            return data;
        } else {
            // Delete head
            int delete = head.data;
            head.data = head.next.data;
            head.next = head.next.next;
            size--;
            return delete; // Change to return data deleted
        }
    }

    /**
     * Delete the final node from the linked list
     */
    public void deleteEnd() {
        Node currNode = head;
        // Delete head if it is the only node
        if (head.next == head) {
            head = null;
        } else {
            // Loop through list to find end
            while (currNode.next.next != head) {
                currNode = currNode.next;
            }
            // Delete the final node
            int temp = currNode.next.data;
            currNode.next = head;
            size--;
        }
    }

    /**
     * Retrieve the data value from a node at a certain index
     * 
     * @param index the index to get the value from
     * @return data the data
     */
    public int getElement(int index) {
        if (index > size) {
            return -1;
        }
        Node n = head;
        // Loop through list to find node at specific index
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        // Return the data of the node
        return n.data;
    }

    /**
     * Return the size of the linked list
     * 
     * @return size the size of the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Add a node with a specific data value at a specific index
     * 
     * @param data     the data value of the node
     * @param position the position to be of the node
     */
    public void addAtIndex(int data, int position) {
        // Reuse of code for same application
        if (position == 1) {
            addStart(data);
        }
        int len = size;
        // Warn user if the position does not exist in the linked list
        if (position > len + 1 || position < 1) {
            System.out.println("\nInvalid Position");
        }
        // Reuse of code for same application
        if (position == len + 1) {
            addEnd(data);
        }
        if (position <= len && position > 1) {
            Node n = new Node(data);
            Node currNode = head;
            // Cycle through nodes to get to the position of insertion
            while ((position - 2) > 0) {
                System.out.println(currNode.data);
                currNode = currNode.next;
                position--;
            }
            // Update nodes
            n.next = currNode.next;
            currNode.next = n;
            size++;
        }
    }

    /**
     * Generate a string version of the linked list
     * 
     * @return res the resulting string
     * @Override
     */
    public String toString() {
        // Generate string version
        if (head == null) {
            return "Empty";
        }
        Node currNode = head;
        String res = "";
        // Loop through to show nodes in list
        while (currNode.next != head) {
            res = res + "Data: " + currNode.data + " --> ";
            currNode = currNode.next;
        }
        res = res + "Data: " + currNode.data;
        int resSize = res.length() - 1;
        res = res + "\n^";
        // Loop through again to create arrow to show circular characteristic
        for (int c = 0; c < resSize; c++) {
            if (c < resSize - 1) {
                res = res + "-";
            } else {
                res = res + "|";
            }
        }
        return res;
    }
}

class Node {
    public int data;
    public Node next;

    /**
     * Create a new instance of Node
     * 
     * @param data the data value of the node
     */
    public Node(int data) {
        // Generate node
        this.data = data;
        this.next = null;
    }
}