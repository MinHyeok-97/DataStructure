package recursion;

public class IndexValueMax {
    public static int max(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return arr[startIdx];
        }

        int middleIdx = (startIdx + endIdx) / 2;
        int leftValue = max(arr, startIdx, middleIdx);
        int rightValue = max(arr, middleIdx + 1, endIdx);

        return Math.max(leftValue, rightValue);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 7, 5, 8, 3, 4};
        System.out.println(max(arr, 0, arr.length - 1));
    }
}
