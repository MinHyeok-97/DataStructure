package recursion;

public class Fibonacci_SplitMerge {
    private static int Fibonacci(int num) {
        if (num <= 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }

        return Fibonacci(num - 1) + Fibonacci(num - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}
