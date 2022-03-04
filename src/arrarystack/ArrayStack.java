package arrarystack;

public class ArrayStack {
    private int top = -1;
    private final Object[] stack;

    public ArrayStack(int stackSize) {
        this.stack = new Object[stackSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return stack.length - 1 == top;
    }

    public void push(Object data) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }

        stack[++top] = data;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        Object tempData = stack[top];
        stack[top--] = null;

        return tempData;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        return stack[top];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isEmpty()) {
            return "Empty Stack";
        }
        sb.append("bottom").append(" | ");
        for (int i = 0; i <= top; i++){
            sb.append(stack[i]).append(" | ");
        }
        sb.append("top");

        return sb.toString();
    }
}
