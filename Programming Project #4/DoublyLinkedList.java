/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL12
 * Program: DoublyLinkedList
 */
public class DoublyLinkedList {
    public Node head;
    public int size;

    public DoublyLinkedList() {
        head = null;
    }

    public void addStart(int data) {
        if (size == 0) {
            // Build head
            Node first = new Node(data);
            head = first;
        } else {
            // Build new node represented by the head and have the new head point to it
            Node newNode = new Node(head.data);
            head.data = data;
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    public void addEnd(int data) {
        if (head == null) {
            addStart(data);
        } else {
            Node n = new Node(data);
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = n;
            size++;
        }
    }

    public int deleteStart() {
        // Delete head if it is the only thing
        if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        } else if (size <= 2) {
            // Delete head if there is only 1 thing after head
            int delete = head.next.data;
            size--;
            head.next = null;
            return delete;
        } else {
            // Delete head
            int delete = head.next.data;
            head.next = head.next.next;
            size--;
            return delete; // Change to return data deleted
        }
    }

    public void deleteEnd() {
        Node currNode = head;
        if (head.next == null) {
            head = null;
        } else {
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            int temp = currNode.next.data;
            currNode.next = null;
            size--;
        }
    }

    public int getElement(int index) {
        if (index > size) {
            return -1;
        }
        Node n = head;
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        return n.data;
    }

    public int getSize() {
        return size;
    }

    public void addAtIndex(int data, int position) {
        if (position == 1) {
            addStart(data);
        }
        int len = size;
        if (position > len + 1 || position < 1) {
            System.out.println("\nInvalid Position");
        }
        if (position == len + 1) {
            addEnd(data);
        }
        if (position <= len && position > 1) {
            Node n = new Node(data);
            Node currNode = head;
            while ((position - 2) > 0) {
                System.out.println(currNode.data);
                currNode = currNode.next;
                position--;
            }
            n.next = currNode.next;
            currNode.next = n;
            size++;
        }
    }

    @Override
    public String toString() {
        // Generate string version
        Node currNode = head;
        String res = "";
        while (currNode != null) {
            if (currNode.next != null) {
                res = res + "Data: " + currNode.data + " --> ";
            } else {
                res = res + "Data: " + currNode.data;
            }
            currNode = currNode.next;
        }
        return res;
    }
}

class Node {
    public int data;
    public Node next;
    public Node last;

    public Node(int data) {
        // Generate node
        this.data = data;
        this.next = null;
        this.last = null;
    }
}