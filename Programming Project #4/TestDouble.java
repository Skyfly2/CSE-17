public class TestDouble {
    public static void main(String[] args) {
        DoublyLinkedListP4 d = new DoublyLinkedListP4();
        Node x = d.addAtStart(2);
        d.addAtStart(1);
        d.print();
        d.addAtEnd(3);
        d.print();
        d.addAfter(4, x);
        d.print();
        d.deleteFromStart();
        d.print();
        System.out.println("Element at index 2: " + d.elementAt(2));
        d.addAtStart(1);
        d.print();
        d.deleteFromEnd();
        d.print();
        System.out.println("Size of the Linked List: " + d.getSize());
    }
}