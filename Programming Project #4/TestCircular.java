public class TestCircular {
    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        c.addStart(3);
        c.addStart(2);
        c.addStart(1);
        System.out.println(c.toString());
        c.deleteStart();
        System.out.println(c.toString());
        c.addEnd(4);
        System.out.println(c.toString());
        System.out.println("Size of linked list: " + c.getSize());
        System.out.println("Element at 2nd position: " + c.getElement(2));
    }
}