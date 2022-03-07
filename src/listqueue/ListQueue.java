package listqueue;

public class ListQueue {
    private Node front;
    private Node rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void add(Object data) {
        Node node = new Node();
        node.data = data;

        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }

        Node removeNode = front;
        Object tempData = removeNode.data;
        front = removeNode.next;

        if (removeNode == rear) {
            rear = null;
        }

        return tempData;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return front.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cusor = front;

        sb.append("앞").append(" -> ");
        while (cusor != null) {
            sb.append(cusor.data).append(" -> ");
            cusor = cusor.next;
        }
        sb.append("뒤");

        return sb.toString();
    }
}
