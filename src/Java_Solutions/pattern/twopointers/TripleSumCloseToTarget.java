package pattern.twopointers;

import java.util.Arrays;

public class TripleSumCloseToTarget {
    public static void main(String[] args) {
        TripleSumCloseToTarget solution = new TripleSumCloseToTarget();
        int[] arr = new int[]{-2, 0, 1, 2};
        int target = 2;
        int expect = 1;
        int actual = solution.searchTriplet(arr, target);
        assert expect == actual;
        System.out.println(actual);

        arr = new int[]{-3, -1, 1, 2};
        target = 1;
        expect = 0;
        actual = solution.searchTriplet(arr, target);
        assert expect == actual;
        System.out.println(actual);

        arr = new int[]{1, 0, 1, 1};
        target = 100;
        expect = 3;
        actual = solution.searchTriplet(arr, target);
        assert expect == actual;
        System.out.println(actual);

    }

    public int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) {
                    return targetSum - targetDiff;
                }
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)) {
                    smallestDifference = targetDiff;
                }
                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return targetSum - smallestDifference;
    }
}
