package dp;

import java.util.Arrays;
//https://labuladong.gitbook.io/algo-en/i.-dynamic-programming/houserobber
public class P00198_House_Robber {
    public static void main(String[] args) {
        P00198_House_Robber soln = new P00198_House_Robber();
        // Test Case 1
        int[] numbers = new int[]{1, 2, 3, 1};
        int result = soln.rob(numbers);
        int result2 = soln.robRecursive(numbers);
        System.out.println(result + " = " + result2);
        assert (result == 4) && (4 == result2);
        // Test Case 2
        numbers = new int[]{2, 7, 9, 3, 1};
        result = soln.rob(numbers);
        result2 = soln.robRecursive(numbers);
        System.out.println(result + " = " + result2);
        assert (result == 12) && (12 == result2);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[nums.length + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] += Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    public int robRecursive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, 0, memo);
    }

    public int robHelper(int[] nums, int start, int[] memo) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] >= 0) {
            return memo[start];
        }
        memo[start] = Math.max(robHelper(nums, start + 2, memo) + nums[start], robHelper(nums, start + 1, memo));
        return memo[start];
    }
}
