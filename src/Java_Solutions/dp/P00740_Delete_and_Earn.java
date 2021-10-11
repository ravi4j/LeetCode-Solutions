package dp;

public class P00740_Delete_and_Earn {
    public static void main(String[] args) {
        P00740_Delete_and_Earn solution = new P00740_Delete_and_Earn();
        int[] numbers = new int[]{3, 4, 2};
        int result = solution.deleteAndEarn(numbers);
        System.out.println(result);
        assert result == 6;
        numbers = new int[]{2, 2, 3, 3, 3, 4};
        result = solution.deleteAndEarn(numbers);
        System.out.println(result);
        assert result == 9;
    }

    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if( nums.length == 1){
            return nums[0];
        }
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] val = new int[max + 1];
        for(int num : nums){
            val[num] +=num;
        }
        return rob(val);
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

}
