/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL12
 * Program: DoublyLinkedList
 */
public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    /**
     * Creates a new instance of a DoublyLinkedList
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Adds a new node as the starting node in the linkedlist
     * 
     * @param data the data value of the node
     */
    public void addStart(int data) {
        if (size == 0) {
            // Build head
            Node first = new Node(data);
            head = first;
            tail = first;
            // Set initial values
            head.last = null;
            head.next = null;
            tail.last = null;
            tail.next = null;
        } else {
            // Build new node represented by the head and have the new head point to it
            if (size == 1) {
                // Set second value equal to tail
                tail = new Node(head.data);
                head.data = data;
                tail.next = null;
                head.next = tail;
                tail.last = head;
            } else {
                if (size == 2) {
                    // Set original node as tail node
                    Node newNode = new Node(head.data);
                    head.data = data;
                    newNode.next = head.next;
                    head.next = newNode;
                    newNode.last = head;
                    tail.last = newNode;
                } else {
                    // Add any more Nodes to a list greater than 2 nodes
                    Node newNode = new Node(head.data);
                    head.data = data;
                    newNode.next = head.next;
                    head.next = newNode;
                    newNode.last = head;
                    newNode.next.last = newNode;
                }
            }
        }
        size++;
    }

    /**
     * Adds a new tail to the linked list
     * 
     * @param data the data value of the node
     */
    public void addEnd(int data) {
        if (head == null) {
            addStart(data);
        } else {
            if (size == 1) {
                // Set new tail node
                tail = new Node(head.data);
                tail.data = data;
                head.last = null;
                tail.last = head;
                head.next = tail;
            } else if (size == 2) {
                // Add third node
                Node newNode = new Node(tail.data);
                tail.last.next = newNode;
                tail.data = data;
                newNode.last = tail.last;
                tail.last = newNode;
                newNode.next = tail;
                head.next = newNode;
            } else {
                // Add any other amount of nodes
                Node newNode = new Node(tail.data);
                tail.last.next = newNode;
                tail.data = data;
                newNode.last = tail.last;
                tail.last = newNode;
                newNode.next = tail;
            }
            size++;
        }
    }

    /**
     * Deletes the node at the head of the linked list
     * 
     * @return data the data deleted
     */
    public int deleteStart() {
        // Delete head if it is the only thing
        if (head.next == null) {
            int data = head.data;
            head = null;
            tail = null;
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
     * Deletes the node at the tail of the linked list
     */
    public void deleteEnd() {
        if (head.next == null) {
            // Set everything to null if there is only one node
            head = null;
            tail = null;
            size--;
        } else {
            // Edit tail to reflect new list
            tail = tail.last;
            tail.next = null;
            size--;
        }
    }

    /**
     * Returns the data value at a specific index
     * 
     * @param index the index to return the data value at
     */
    public int getElement(int index) {
        if (index > size) {
            return -1;
        }
        Node n;
        if (index > size / 2) {
            // Go from tail if index is past half point
            n = tail;
            int c = 0;
            // Cycle throug list starting at tail to get to element
            while (c < size - index) {
                n = n.last;
                c++;
            }
        } else {
            // Cycle from head for more efficiency to get value
            n = head;
            // Cycle through list starting at the head to get the element
            while (index - 1 != 0) {
                n = n.next;
                index--;
            }
        }
        // Return the element
        return n.data;
    }

    /**
     * Returns the size of the LinkedList
     * 
     * @return size the size of the list
     */
    public int getSize() {
        return size;
    }

    /*
     * Adds a node with specific data to a point with a specific index in the linked
     * list
     * 
     * @param data the data value of the node
     * 
     * @param position the index of the node to be
     */
    public void addAtIndex(int data, int position) {
        // Reuse of code for same application
        if (position == 1) {
            addStart(data);
        }
        // Warn user if the position does not exist in the linked list
        int len = size;
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
                currNode = currNode.next;
                position--;
            }
            // Update nodes
            // currNode.last.next = n;
            // n.next = currNode;
            // n.last = currNode.last;
            // currNode.last = n;
            n.next = currNode.next;
            currNode.next = n;
            n.last = currNode;
            n.next.last = n;
            // System.out.println(n.last.data);
            size++;
        }
    }

    /**
     * Returns a string version of the linked list
     * 
     * @return res the string version of the linked list
     * @Override
     */
    public String toString() {
        if (head == null) {
            return "Empty";
        } else {
            // Generate string version
            Node currNode = head;
            String res = "";
            while (currNode.next != null) {
                res = res + "Data: " + currNode.data + " --> ";

                currNode = currNode.next;
            }
            res = res + "Data: " + tail.data;
            return res;
        }
    }
}

class Node {
    public int data;
    public Node next;
    public Node last;

    /**
     * Creates a new instance of the Node object
     * 
     * @param data the data value of the node
     */
    public Node(int data) {
        // Generate node
        this.data = data;
        this.next = null;
        this.last = null;
    }
}