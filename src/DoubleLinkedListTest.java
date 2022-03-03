import doublelinkedlist.NodeDoubleLinkedList;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        NodeDoubleLinkedList dll = new NodeDoubleLinkedList();

        dll.add(0, "A");
        System.out.println(dll);
        dll.add(1, "B");
        System.out.println(dll);
        dll.add(2, "C");
        System.out.println(dll);
        dll.remove(1);
        System.out.println(dll);
        dll.add(2, "D");
        System.out.println(dll);

    }
}
