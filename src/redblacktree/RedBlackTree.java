package redblacktree;

import static redblacktree.Node.BLACK;
import static redblacktree.Node.RED;

public class RedBlackTree {

    private Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }

        root.color = BLACK;
    }

    public void remove(int key) {
        removeNode(root, key);
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

    private void insertNode(Node x, Node newNode) {
        if (newNode.key < x.key && !isExist(x.left)) {
            x.left = newNode;
            newNode.parent = x;
        } else if (newNode.key > x.key && !isExist(x.right)) {
            x.right = newNode;
            newNode.parent = x;
        } else if (newNode.key < x.key) {
            insertNode(x.left, newNode);
        } else {
            insertNode(x.right, newNode);
        }

        insertFixUp(x);
    }

    private void removeNode(Node x, int key) {
        if (x == null) {
            throw new RuntimeException("노드를 찾을 수 없음");
        } else if (key < x.key) {
            removeNode(x.left, key);
        } else if (key > x.key) {
            removeNode(x.right, key);
        } else {
            if (isExist(x.left)) {
                Node predecessor = getLargestNode(x.left);
                int removeKey = x.key;
                x.key = predecessor.key;
                predecessor.key = removeKey;

                removeNode(x.left, predecessor.key);
            } else if (isExist(x.right)) {
                Node successor = getSmallNode(x.right);
                int removeKey = x.key;
                x.key = successor.key;
                successor.key = removeKey;

                removeNode(x.right, successor.key);
            } else {
                if (x == root) {
                    root = null;
                } else {
                    if (isBlack(x)) {
                        removeFixUp(x);
                    }

                    if (x == x.parent.left) {
                        x.parent.left = null;
                    } else if (x == x.parent.right) {
                        x.parent.right = null;
                    }
                    x.parent = null;
                }
            }
        }
    }

    private Node searchNode(Node parent, int key) {
        if(parent == null) {
            throw new RuntimeException("노드를 찾을 수 없음.");
        } else if (key < parent.key) {
            parent = searchNode(parent.left, key);
        } else if (key > parent.key) {
            parent = searchNode(parent.right, key);
        }

        return parent;
    }

    private void insertFixUp(Node g) {
        if (isRed(g.right) && isRed(g.right.left) && isBlack(g.left)) { //삼촌 검정, 우 - 좌 Double Red -> RL 회전
            LL_rotate(g.right);
            swapColor(g, g.right);
            RR_rotate(g);
        } else if (isRed(g.right) && isRed(g.right.right) && isBlack(g.left)) {
            swapColor(g, g.right);
            RR_rotate(g);
        } else if (isRed(g.right) && isRed(g.right.right) && isRed(g.left)) {
            g.color = RED;
            g.right.color = BLACK;
            g.left.color = BLACK;
        } else if (isRed(g.left) && isRed(g.left.right) && isBlack(g.right)) { //삼촌 검정, 좌 - 우 Double Red -> LR 회전
            RR_rotate(g.left);
            swapColor(g, g.left);
            LL_rotate(g);
        } else if (isRed(g.left) && isRed(g.left.left) && isBlack(g.right)) {
            swapColor(g, g.left);
            LL_rotate(g);
        } else if (isRed(g.left) && isRed(g.left.left) && isRed(g.right)) {
            g.color = RED;
            g.left.color = BLACK;
            g.right.color = BLACK;
        }
    }

    private void removeFixUp(Node x) {
        while (x != root && isBlack(x)) {
            if (x == x.parent.left) {
                Node w = x.parent.right;    //x.parent.right -> 형제
                // TODO: case1
                if (isRed(w)) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    RR_rotate(x.parent);
                    w = x.parent.right;
                } else if (isBlack(w.left) && isBlack(w.right)){
                    // TODO: case2
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (isBlack(w.right)) {
                        // TODO: case3
                        w.left.color = BLACK;
                        w.color = RED;
                        LL_rotate(w);

                        w = x.parent.right;
                    }
                    // TODO: case4
                    w.color = w.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    RR_rotate(x.parent);
                    break;
                }
            } else if (x == x.parent.right){
                Node w = x.parent.left;
                // TODO: case1
                if (isRed(w)) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    LL_rotate(x.parent.left);
                } else if (isBlack(w.left) && isBlack(x.right)) {
                    // TODO: case2
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (isBlack(w.left)) {
                        // TODO: case3
                        w.color = RED;
                        w.right.color = BLACK;
                        RR_rotate(w);

                        w = x.parent.left;
                    }
                    // TODO: case4
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    LL_rotate(x.parent);
                    break;
                }
            }
        }
        x.color = BLACK;
    }

    private Node getLargestNode(Node x) {
        if (x.right == null) {
            return x;
        }

        return getLargestNode(x.right);
    }

    private Node getSmallNode(Node x) {
        if (x.left == null) {
            return x;
        }

        return getSmallNode(x.left);
    }

    private void inorderTraversal(Node node) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        inorderTraversal(node.right);
    }

    private void printHelper(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == RED ? "RED" : "BLACK";
            System.out.println(root.key + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    private void LL_rotate(Node P) {
        Node GP = P.parent;
        Node L = P.left;
        Node LR = L.right;
        L.right = P;
        P.left = LR;

        P.parent = L;
        if (isExist(LR)) {
            LR.parent = P;
        }

        L.parent = GP;

        if (!isExist(GP)) {
            this.root = L;
        } else {
            if (GP.left == P) {
                GP.left = L;
            } else if (GP.right == P) {
                GP.right = L;
            }
        }
    }

    private void RR_rotate(Node P) {
        Node GP = P.parent;
        Node R = P.right;
        Node RL = R.left;
        R.left = P;
        P.right = RL;

        P.parent = R;
        if(isExist(RL)) {
            RL.parent = P;
        }

        R.parent = GP;

        if (!isExist(GP)) {
            this.root = R;
        } else {
            if (GP.left == P) {
                GP.left = R;
            } else if (GP.right == P) {
                GP.right = R;
            }
        }
    }

    private void swapColor(Node nodeA, Node nodeB) {
        int color = nodeA.color;
        nodeA.color = nodeB.color;
        nodeB.color = color;
    }

    private boolean isRed(Node x) {
        return isExist(x) && RED == x.color;
    }

    private boolean isBlack(Node x) {
        return !isExist(x) || BLACK == x.color;
    }

    private boolean isExist(Node x) {
        return x != null;
    }

}
