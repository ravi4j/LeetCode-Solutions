package dp;

import java.util.Arrays;

public class P0045_Jump_Game_II {
    public static void main(String[] args) {
        P0045_Jump_Game_II solution = new P0045_Jump_Game_II();
        int[] numbers = new int[]{2, 3, 1, 1, 4};
        int result = solution.jumpDP(numbers);
        System.out.println(result);
        assert result == 2;
        numbers = new int[]{2, 3, 0, 1, 4};
        result = solution.jumpDP(numbers);
        System.out.println(result);
        assert result == 2;
    }

    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        jumpHelper(nums, 0, memo);
        return memo[0];
    }

    public int jumpHelper(int[] nums, int start, int[] memo) {
        if (start == nums.length - 1) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int minSteps = Integer.MAX_VALUE;
        int farthestJump = Math.min(start + nums[start], nums.length - 1);
        for (int i = start + 1; i <= farthestJump; i++) {
            int steps = jumpHelper(nums, i, memo);
            if (steps == Integer.MAX_VALUE) {
                continue;  //dead end
            }
            minSteps = Math.min(minSteps, steps + 1);
        }
        memo[start] = minSteps;
        return memo[start];
    }

    public int jumpDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i = n - 2; i >= 0 ; i--){
            int min = Integer.MAX_VALUE;
            int farthestJump = Math.min(i + nums[i] , n - 1);
            for(int j = i + 1; j <= farthestJump;j++){
                min = Math.min(dp[j] , min);
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }

    public int jumpBottomUP(int[] nums, int[] memo) {
         return 0;
    }

    public int jumpGreedy(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
