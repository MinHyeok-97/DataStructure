package binarytree;

public class TreeDFSTest {
    public static void main(String[] args) {
        BinaryTreeDFS binaryTree = new BinaryTreeDFS();
        binaryTree.addData(1);
        binaryTree.addData(2);
        binaryTree.addData(3);
        binaryTree.addData(4);
        binaryTree.addData(5);
        binaryTree.addData(6);
        binaryTree.addData(7);

        System.out.println("전위 순회");
        binaryTree.preOrderTraversal();

        System.out.println("중위 순회");
        binaryTree.inOrderTraversal();

        System.out.println("후위 순회");
        binaryTree.postOrderTraversal();
    }
}
