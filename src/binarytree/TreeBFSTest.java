package binarytree;

public class TreeBFSTest {
    public static void main(String[] args) {
        BinaryTreeBFS binaryTree = new BinaryTreeBFS();

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);

        System.out.println("레벨 순회");
        binaryTree.levelOrder();
    }
}
