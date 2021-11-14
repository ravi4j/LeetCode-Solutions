package pattern.twopointers;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        TripletsWithSmallerSum solution = new TripletsWithSmallerSum();
        int[] arr = new int[]{-1, 0, 2, 3};
        int target = 3;
        int expect = 2;
        int actual = solution.searchTriplets(arr, target);
        assert expect == actual;
        System.out.println(actual);

        arr = new int[]{-1, 4, 2, 1, 3};
        target = 5;
        expect = 4;
        actual = solution.searchTriplets(arr, target);
        assert expect == actual;
        System.out.println(actual);
    }

    public int searchTriplets(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, targetSum - arr[i], i);
        }
        return count;
    }

    public int searchPair(int[] arr, int targetSum, int start) {
        int count = 0;
        int left = start + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < targetSum) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
