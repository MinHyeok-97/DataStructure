package circlequeue;

public class CircleQueueTest {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);

        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.poll();
        System.out.println(circleQueue);
        System.out.println(circleQueue.peek());
        circleQueue.add(3);
        System.out.println(circleQueue);
        circleQueue.add(1);
        System.out.println(circleQueue);
    }
}
