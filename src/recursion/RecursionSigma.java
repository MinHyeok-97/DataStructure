package recursion;

public class RecursionSigma {
    private static int f(int n) {
        return n;
    }

    private static int sigma(int n, int sum) {
        if (n > 5) {
            return sum;
        }

        int nextSum = (n == 1) ? f(n) : sum + f(n);
        return sigma(n + 1, nextSum);
    }

    public static void main(String[] args) {
        System.out.println(sigma(1, 1));
    }
}
