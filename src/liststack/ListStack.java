package liststack;

public class ListStack {
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Object data) {
        Node node = new Node();
        node.data = data;

        if (!isEmpty()) {
            node.next = head;
        }

        head = node;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        Node removeData = head;
        Object tempData = removeData.data;
        head = removeData.next;

        removeData.data = null;
        removeData.next = null;

        return tempData;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isEmpty()) {
            sb.append("Empty Stack");
        }
        sb.append("top").append(" | ");
        Node pointer = head;
        while (pointer != null) {
            sb.append(pointer.data).append(" | ");
            pointer = pointer.next;
        }
        sb.append("bottom");

        return sb.toString();
    }
}
