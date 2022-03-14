package binarysearchtree;

public class test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(5);
        bst.add(2);
        bst.add(9);
        bst.add(3);
        bst.add(7);
        bst.add(4);
        bst.add(8);
        bst.add(1);
        bst.add(6);
        bst.printTree();
        System.out.println("순회: ");
        bst.traversal();

        bst.remove(9);
        bst.printTree();
    }
}
