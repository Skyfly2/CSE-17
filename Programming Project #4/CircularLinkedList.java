/*
 * CSE 17 Fall 2019
 * @author Arielle Carr modified by Asher Hamrick
 * IBL12
 * Program: CircularLinkedList
 */
public class CircularLinkedList {
    public Node head;
    public int size;

    public CircularLinkedList() {
        head = null;
    }

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

    public void addEnd(int data) {
        if (head == null) {
            addStart(data);
        } else {
            Node n = new Node(data);
            Node currNode = head;
            while (currNode.next != head) {
                currNode = currNode.next;
            }
            currNode.next = n;
            n.next = head;
            size++;
        }
    }

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

    public void deleteEnd() {
        Node currNode = head;
        if (head.next == head) {
            head = null;
        } else {
            while (currNode.next.next != head) {
                currNode = currNode.next;
            }
            int temp = currNode.next.data;
            currNode.next = head;
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
        while (currNode.next != head) {
            res = res + "Data: " + currNode.data + " --> ";
            currNode = currNode.next;
        }
        res = res + "Data: " + currNode.data;
        int resSize = res.length() - 1;
        res = res + "\n^";
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

    public Node(int data) {
        // Generate node
        this.data = data;
        this.next = null;
    }
}