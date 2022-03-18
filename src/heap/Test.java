package heap;

public class Test {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(6);
        System.out.println("--Max Heap--");
        maxHeap.printTree();

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }
    }
}
