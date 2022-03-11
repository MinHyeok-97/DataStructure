package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS {
    Node root;

    public void add(int key) {
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
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

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();

            visit(parentNode);

            if (parentNode.left != null) {
                queue.offer(parentNode.left);
            }
            if (parentNode.right != null) {
                queue.offer(parentNode.right);
            }

            System.out.print("");
        }
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

    private void visit(Node node) {
        System.out.printf("%d ",node.key);
    }


}
