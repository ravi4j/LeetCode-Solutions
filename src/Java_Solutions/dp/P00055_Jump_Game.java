package dp;

import java.util.Arrays;
//https://shunchizhou.com/LeetCode/leetCode-55-Jump-Game.html
public class P00055_Jump_Game {
    enum Algorithm {RECURSIVE, RECURSIVE_MEMO, BOTTOM_UP, GREEDY , GREEDY2 , DP}

    public static void main(String[] args) {
        P00055_Jump_Game solution = new P00055_Jump_Game();
        int[] numbers = new int[]{2, 3, 1, 1, 4};
        boolean result = solution.canJump(numbers, Algorithm.DP);
        System.out.println(result);
        assert result;
        numbers = new int[]{3, 2, 1, 0, 4};
        result = solution.canJump(numbers, Algorithm.DP);
        System.out.println(result);
        assert !result;

    }

    public boolean canJump(int[] nums, Algorithm algorithm) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        memo[nums.length - 1] = 1;
        return switch (algorithm) {
            case RECURSIVE -> canJumpRecursive(nums, 0);
            case RECURSIVE_MEMO -> canJumpRecursiveWithMemo(nums, 0, memo);
            case BOTTOM_UP -> canJumpBottomUP(nums, memo);
            case GREEDY -> canJumpGreedy(nums);
            case GREEDY2 -> canJumpGreedy(nums);
            case DP -> canJumpDP(nums);
        };
    }


    public boolean canJumpRecursive(int[] nums, int start) {
        if (start == nums.length - 1) {
            return true;
        }
        int farthestJump = Math.min(start + nums[start], nums.length - 1);
        for (int nextJump = start + 1; nextJump <= farthestJump; nextJump++) {
            if (canJumpRecursive(nums, nextJump)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJumpRecursiveWithMemo(int[] nums, int start, int[] memo) {
        if (memo[start] != -1) {
            return memo[start] == 1;
        }
        int farthestJump = Math.min(start + nums[start], nums.length - 1);
        for (int nextJump = start + 1; nextJump <= farthestJump; nextJump++) {
            if (canJumpRecursive(nums, nextJump)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 0;
        return false;
    }

    public boolean canJumpBottomUP(int[] nums, int[] memo) {
        int n = nums.length - 1;
        for (int i = n - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1; // true
                    break;
                }
            }
        }
        // check if we can reach from index 0
        return memo[0] == 1;
    }

    public boolean canJumpDP(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp , false);
        dp[n-1] = true;
        for(int i = n - 2; i >= 0 ; i--){
            int farthestJump = Math.min(i + nums[i] , n - 1);
            dp[i] = dp[farthestJump];
        }
        return dp[0];
    }

    public boolean canJumpGreedy(int[] nums) {
        int n = nums.length - 1;
        int lastPosition = n;
        for (int i = n - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        // check if we can reach from index 0
        return lastPosition == 0;
    }

    public boolean canJumpGreedy2(int[] nums) {
        int curFarthest = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if(i > curFarthest){
                return false;
            }
            curFarthest = Math.max(curFarthest, i + nums[i]);
        }
        return true;
    }

}
