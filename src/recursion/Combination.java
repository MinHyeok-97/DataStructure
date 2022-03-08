package recursion;

public class Combination {
    private static int comb(int n, int r) {
        if (n == 0 || n == r) {
            return 1;
        }

        return comb(n - 1, r - 1) + comb(n - 1, r);
    }

    public static void main(String[] args) {
        System.out.println(comb(5, 3));
    }
}
