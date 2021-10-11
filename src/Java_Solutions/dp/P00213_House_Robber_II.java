package dp;

public class P00213_House_Robber_II {
    public static void main(String[] args) {
        P00213_House_Robber_II soln = new P00213_House_Robber_II();
        int[] numbers = new int[]{2, 3, 2};
        int result = soln.rob(numbers);
        System.out.println(result);
        assert result == 3;
        // Test Case 2
        numbers = new int[]{1, 2, 3, 1};
        result = soln.rob(numbers);
        System.out.println(result);
        assert result == 4;
        // Test Case 3
        numbers = new int[]{1, 2, 3};
        result = soln.rob(numbers);
        System.out.println(result);
        assert result == 3;

    }

    public int rob(int[] nums) {
        if( nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        return Math.max(robHelper(nums , 0 , n - 2) , robHelper(nums , 1 , n-1));
    }

    public int robHelper(int[] nums , int start , int end) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = end; i >= start; i--) {
            dp[i] += Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }

}
