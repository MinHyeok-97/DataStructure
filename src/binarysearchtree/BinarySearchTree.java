package binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            root = insertNode(root, newNode);
        }
    }

    private Node insertNode(Node x, Node newNode) {
        if (x == null) {
            return newNode;
        } else if (newNode.key < x.key) {
            x.left = insertNode(x.left, newNode);
        } else {
            x.right = insertNode(x.right, newNode);
        }
        return x;
    }

    public void remove(int key) {
        root = removeNode(root, key);
    }

    private Node removeNode(Node x, int key) {
        if (x == null) {
            throw new RuntimeException("노드를 찾을 수 없습니다.");
        } else if (key < x.key) {
            x.left = removeNode(x.left, key);
        } else if (key > x.key) {
            x.right = removeNode(x.right, key);
        } else {
            if (x.left != null) {
                Node predecessor = getLargestNode(x.left);

                int removeKey = key;
                x.key = predecessor.key;
                predecessor.key = removeKey;

                x.left = removeNode(x.left, key);
            } else if (x.right != null) {
                Node successor = getSmallNode(x.right);

                int removeKey = key;
                x.key = successor.key;
                successor.key = removeKey;
            } else {
                return null;
            }
        }

        return x;
    }

    public int search(int key) {
        return searchNode(root, key).key;
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    private void printHelper(Node x, String indent, boolean last) {
        if (x != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(x.key);
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
    }

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    private void inorderTraversal(Node x) {
        if (x == null) {
            return;
        }

        inorderTraversal(x.left);
        System.out.printf("%d ", x.key);
        inorderTraversal(x.right);
    }

    private Node searchNode(Node x, int key) {
        Node node = x;

        if (node == null) {
            throw new RuntimeException("노드를 찾을 수 없습니다.");
        } else if (key < node.key) {
            node = searchNode(x.left, key);
        } else if (key > node.key) {
            node = searchNode(x.right, key);
        }

        return node;
    }

    private Node getSmallNode(Node x) {
        if (x.left == null) {
            return x;
        }

        return getSmallNode(x.left);
    }

    private Node getLargestNode(Node x) {
        if (x.right == null) {
            return x;
        }

        return getLargestNode(x.right);
    }


}
