package recursion;

public class Fibonacci_RepeatSequence {
    private static int Fibonacci(int n, int twoPrevVal, int onePrevVal) {
        if(n > 5) {
            return onePrevVal;
        }

        int value = (n == 1 || n == 2) ? 1 : onePrevVal + twoPrevVal;
        return Fibonacci(n + 1, onePrevVal, value);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(1, 1, 1));
    }
}


