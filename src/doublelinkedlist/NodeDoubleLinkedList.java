package doublelinkedlist;

public class NodeDoubleLinkedList {
    Node head = new Node();
    Node tail = new Node();
    int size = 0;

    public NodeDoubleLinkedList() {
        head.right = tail;
        tail.left = head;
    }

    private Node findNode(int searchIndex) {
        if (searchIndex < 0 || searchIndex > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int nodeIndex;
        Node pointer;

        if (size / 2 > searchIndex) {
            nodeIndex = -1;
            pointer = head;

            while(nodeIndex != searchIndex) {
                ++nodeIndex;
                pointer = pointer.right;
            }
        } else {
            nodeIndex = size;
            pointer = tail;

            while(nodeIndex != searchIndex) {
                --nodeIndex;
                pointer = pointer.left;
            }
        }

        return pointer;
    }

    public Object getData(int searchIndex) {
        return findNode(searchIndex).data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(int index, Object data) {
        Node node = new Node();
        node.data = data;

        Node foundNode = findNode(index);
        Node leftNode = foundNode.left;

        node.right = foundNode;
        foundNode.left = node;

        node.left = leftNode;
        leftNode.right = node;

        ++size;
    }

    public void remove(int index) {
        Node foundNode = findNode(index);
        Node leftNode= foundNode.left;
        Node rightNode = foundNode.right;

        leftNode.right = rightNode;
        rightNode.left = leftNode;

        foundNode.left = null;
        foundNode.data = null;
        foundNode.right = null;

        --size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pointer = head.right;
        sb.append("head").append(" -> ");

        while (tail != pointer) {
            sb.append(pointer.data).append(" -> ");
            pointer = pointer.right;
        }
        sb.append("null ");
        if (head != tail.left) {
            sb.append(", tail(").append(tail.left.data).append("), ");
        }
        pointer = tail.left;
        sb.append("tail").append(" -> ");
        while (head != pointer) {
            sb.append(pointer.data).append(" -> ");
            pointer = pointer.left;
        }
        sb.append("null");
        if (tail != head.right) {
            sb.append(", head(").append(head.right.data).append(")");
        }

        return sb.toString();
    }
}
