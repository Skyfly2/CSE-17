public class TestDouble {
    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        System.out.println(d.toString());
        d.addStart(2);
        d.addStart(1);
        d.addStart(7);
        d.addStart(6);
        d.addEnd(9);
        System.out.println(d.toString());
        d.addEnd(3);
        System.out.println(d.toString());
        d.addAtIndex(42, 3);
        System.out.println(d.toString());
        d.deleteEnd();
        d.deleteEnd();
        d.deleteEnd();
        d.deleteEnd();
        d.deleteEnd();
        d.deleteEnd();
        d.deleteEnd();
        System.out.println(d.toString());
        System.out.println("Size of the Linked List: " + d.getSize());
        System.out.println("Element at index 6: " + d.getElement(5));
        d.addStart(11);
        d.addStart(12);
        System.out.println(d.toString());
        d.deleteStart();
        System.out.println(d.toString());
        System.out.println("Size of the Linked List: " + d.getSize());
    }
}