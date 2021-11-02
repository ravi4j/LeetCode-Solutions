package pattern.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {
    public static void main(String[] args) {
        PairWithTargetSum solution = new PairWithTargetSum();
        int[] arr = new int[]{1, 2, 3, 4, 6};
        int targetSum = 6;
        int[] actual = solution.search(arr, targetSum);
        System.out.println(Arrays.toString(actual));
        arr = new int[]{2, 5, 9, 11};
        targetSum = 11;
        actual = solution.search(arr, targetSum);
        System.out.println(Arrays.toString(actual));
    }

    public int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                return new int[]{left, right};
            }
            if (sum < targetSum) {
                left++;
            } else  {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
