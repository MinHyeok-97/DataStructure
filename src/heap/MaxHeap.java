package heap;

import java.util.Arrays;

public class MaxHeap {

    int[] queue;
    int size = 0;

    public MaxHeap() {
        this.queue = new int[4];
    }

    public void add(int data) {
        if (size == queue.length) {
            queue = Arrays.copyOf(queue, size + 4);
        }
        queue[size++] = data;
        upHeap(size - 1);
    }

    public int remove() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty.");
        }
        int removeData = queue[0];
        swap(0, size - 1);
        queue[size - 1] = 0;
        --size;

        downHeap(0);
        return removeData;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        }
        return queue[0];
    }

    private void downHeap(int index) {
        if (!isExistLeftChild(index)) {
            return;
        }

        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (isExistLeftChild(index)) {  // 좌/우측 자식이 존재하는 경우
            int maxValue = Math.max(queue[index], Math.max(queue[leftChildIndex], queue[rightChildIndex]));

            if (maxValue == queue[leftChildIndex]) {
                swap(leftChildIndex, index);
                downHeap(leftChildIndex);
            } else if (maxValue == queue[rightChildIndex]) {
                swap(rightChildIndex, index);
                downHeap(rightChildIndex);
            }
        } else {    //좌측 자식만 존재하는 경우
            int maxValue = Math.max(queue[index], queue[leftChildIndex]);

            if (maxValue == queue[leftChildIndex]) {
                swap(leftChildIndex, index);
                downHeap(leftChildIndex);
            }
        }
    }

    private void upHeap(int index) {
        if (index <= 0) {
            return;
        }

        int parentIndex = parentIndex(index);
        if (queue[index] > queue[parentIndex]) {
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }

    private void swap(int index1, int index2) {
        int tempData = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = tempData;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) +2;
    }

    private boolean isExistRightChild(int index) {
        return size > rightChildIndex(index);
    }

    private boolean isExistLeftChild(int index) {
        return size > leftChildIndex(index);
    }

    private void printHelper(int visitIndex, String indent, boolean last) {
        if (isEmpty()) {
            System.out.println("Heap is Empty");
            return;
        } else if (size <= visitIndex) {
            return;
        }

        System.out.print(indent);
        if (last) {
            System.out.print("R----");
            indent += "   ";
        } else {
            System.out.print("L----");
            indent += "|  ";
        }

        System.out.println(queue[visitIndex]);
        printHelper(visitIndex * 2 + 1, indent, false);
        printHelper(visitIndex * 2 + 2, indent, true);

    }

    public void printTree() {
        printHelper(0, "", true);
    }
}
