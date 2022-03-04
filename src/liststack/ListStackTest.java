package liststack;

public class ListStackTest {
    public static void main(String[] args) {
        ListStack stack = new ListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
