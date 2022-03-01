import list.SinglyLinkedList;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.add(0, "A");
        System.out.println(sll);

        sll.add(1, "C");
        System.out.println(sll);

        sll.remove(1);
        System.out.println(sll);

        sll.add(1, "E");
        System.out.println(sll);

        sll.add(2, "T");
        System.out.println(sll);

        System.out.printf("노드의 개수 : %d\n", sll.size());
        System.out.printf("1번 인덱스의 값 : %s\n", sll.getData(1));

    }
}
