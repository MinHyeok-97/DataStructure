package recursion;

public class IndexValueSum {
    public static int sum(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return arr[startIdx];
        }

        int middleIdx = (startIdx + endIdx) / 2;

        return sum(arr, startIdx, middleIdx) + sum(arr, middleIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        int[] arr= {4, 2, 5, 1, 5, 3, 1, 2};
        System.out.println(sum(arr, 0, arr.length - 1));
    }
}

