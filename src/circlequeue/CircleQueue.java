package circlequeue;

import java.util.Arrays;

public class CircleQueue {
    private final Object[] queue;

    private int front = 0;
    private int rear = 0;

    public CircleQueue(int size) {
        this.queue = new Object[size];
    }

    public void add(Object data) {
        if (front == rear && queue[rear] != null) {
            throw new RuntimeException("Queue is full.");
        }

        queue[rear] = data;
        ++rear;
        rear = rear % queue.length;
    }

    public Object poll() {
        if (front == rear && queue[front] == null) {
            throw new RuntimeException("Queue is empty.");
        }

        Object tempData = queue[front];
        queue[front] = null;
        ++front;
        front = front % queue.length;

        return tempData;
    }

    public Object peek() {
        return queue[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int tempFront = front;
        int tempRear = rear;

        sb.append("앞").append(" -> ");

        if (tempFront == tempRear && queue[tempFront] != null) {
            sb.append(queue[tempFront]).append(" -> ");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }

        while (tempFront != tempRear) {
            sb.append(queue[tempFront]).append(" -> ");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }

        sb.append("뒤");

        return sb.toString();


    }
}


