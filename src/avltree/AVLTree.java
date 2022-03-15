package avltree;

public class AVLTree {
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

    public void remove(int key) {
        root = removeNode(root, key);
    }

    public int search(int key) {
        return searchNode(root, key).key;
    }

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    private Node rotate(Node x) {
        int xNodeBalance = getBalance(x);

        if (Math.abs(xNodeBalance) >= 2) {
            //xNodeBalance = 양수 L , 음수 R
            if (xNodeBalance > 1 && 0 <= getBalance(x.left)) {
                x = LL_rotate(x);
            } else if (xNodeBalance > 1 && -1 == getBalance(x.left)) {
                x.left = RR_rotate(x.left);
                x = LL_rotate(x);
            } else if (xNodeBalance < -1 && 0 >= getBalance(x.right)) {
                x = RR_rotate(x);
            } else if (xNodeBalance < -1 && 1 == getBalance(x.right)) {
                x.right = LL_rotate(x.right);
                x = RR_rotate(x);
            }
        }

        return x;
    }

    private Node LL_rotate(Node P) {
        Node L = P.left;
        Node LR = L.right;

        L.right = P;
        P.left = LR;

        changeNodeHeight(P);
        changeNodeHeight(L);

        return L;
    }

    private Node RR_rotate(Node P) {
        Node R = P.right;
        Node RL = R.left;

        R.left = P;
        P.right = RL;

        changeNodeHeight(P);
        changeNodeHeight(R);

        return R;
    }

    private void changeNodeHeight(Node x) {
        x.height = getHeight(x);
    }

    private int getHeight(Node x) {
        int leftChildHeight = (x.left != null) ? x.left.height : -1;
        int rightChildHeight = (x.right != null) ? x.right.height : -1;

        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    private int getBalance(Node x) {
        int leftChildBalance = (x.left != null) ? x.left.height : -1;
        int rightChildBalance = (x.right != null) ? x.right.height : -1;

        return leftChildBalance - rightChildBalance;
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

            System.out.println(x.key + "(h:" + x.height + ")");
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
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

    private Node insertNode(Node x, Node newNode) {
        if (x == null) {
            return newNode;
        } else if (newNode.key < x.key) {
            x.left = insertNode(x.left, newNode);
        } else {
            x.right = insertNode(x.right, newNode);
        }

        changeNodeHeight(x);
        return rotate(x);
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

                x.right = removeNode(x.right, key);
            }
        }

        changeNodeHeight(x);
        return rotate(x);
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
