/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * IBL12
 * Program: TestSingle
 */
public class TestSingle {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        // Develop LinkedList using all of the methods
        list.addStart(7);
        list.addStart(5);
        list.addStart(8);
        list.addAtIndex(17, 2);
        list.deleteStart();
        list.addAtIndex(96, 2);
        list.addStart(11);
        list.addEnd(9);
        list.addEnd(42);
        list.deleteEnd();

        // Display functional operations
        System.out.println(list.toString());
        System.out.println("Final Size: " + list.getSize());
        System.out.println("Element at position 3: " + list.getElement(3));
        System.out.println("Position of element 5: " + list.search(5));
    }
}