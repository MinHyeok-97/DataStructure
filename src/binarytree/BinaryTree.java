package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void addData(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node parentNode = queue.poll();

                if (parentNode.left != null) {
                   queue.offer(parentNode.left);
                } else {
                    parentNode.left = newNode;
                    break;
                }

                if (parentNode.right != null) {
                    queue.offer(parentNode.right);
                } else {
                    parentNode.right = newNode;
                    break;
                }
            }
        }
    }

    public void inOrderTraversal() {
        inOrder(root);
        System.out.println("");
    }

    public void preOrderTraversal() {
        preOrder(root);
        System.out.println("");
    }

    public void postOrderTraversal() {
        postOrder(root);
        System.out.println("");
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        visit(node);
    }

    private void visit(Node node) {
        System.out.printf("%d ", node.key);
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

}
