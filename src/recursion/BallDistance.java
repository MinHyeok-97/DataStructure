package recursion;

public class BallDistance {
    private static int distanceSum (int height, int distance) {
        if (height < 1) {
            return distance;
        }

        int upDown = (distance == 0) ? height : height * 2;
        int sum = distance + upDown;

        return distanceSum(height / 2, sum);
    }

    public static void main(String[] args) {
        System.out.println(distanceSum(16, 0));
    }
}
