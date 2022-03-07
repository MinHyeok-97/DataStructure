package listqueue;

public class ListQueueTest {
    public static void main(String[] args) {
        ListQueue listQueue = new ListQueue();

        listQueue.add(2);
        listQueue.add(3);
        listQueue.poll();
        System.out.println(listQueue);
        System.out.println(listQueue.peek());
        listQueue.add(4);
        System.out.println(listQueue);
        listQueue.add(2);
        System.out.println(listQueue);
    }
}
