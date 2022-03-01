package list;

public class SinglyLinkedList {

    Node head;
    int size = 0;

    private Node findNode(int searchIndex) {
        /**
         *  찾는 노드 index가 음수거나,
         *  노드의 개수보다 많거나 같으면 예외 발생
         */

        if (searchIndex < 0 || searchIndex >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int nodeIndex = 0;
        Node pointer = head;

        /**
         * 찾는 노드의 index와 노드의 순서가 동일할 때 까지
         * 노드의 참조값을 이용하여 이동
         */

        while (nodeIndex != searchIndex) {
            ++nodeIndex;
            pointer = pointer.next;
        }

        return pointer;
    }

    public Object getData(int searchIndex) {
        return findNode(searchIndex).data;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public int size() {
        return size;
    }

    public void addLast(Object data) {
        add(size, data);
    }

    public void addFirst(Object data) {
        add(0, data);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void removeFirst() {
        remove(0);
    }

    public void add(int index, Object data) {
        Node node = new Node();
        node.data = data;

        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node foundNode = findNode(index - 1);
            node.next = foundNode.next;
            foundNode.next = node;
        }
        ++size;
    }

    public void remove(int index) {
        if (index == 0 && null != head) {
            head = head.next;
        } else {
            Node prevNode = findNode(index - 1);
            prevNode.next = prevNode.next.next;
        }
        --size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node pointer = head;
        sb.append("head").append(" -> ");

        while (pointer != null) {
            sb.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }

        sb.append("null");
        return sb.toString();
    }
}
