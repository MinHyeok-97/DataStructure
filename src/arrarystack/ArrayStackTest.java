package arrarystack;

public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.peek());

    }

}
