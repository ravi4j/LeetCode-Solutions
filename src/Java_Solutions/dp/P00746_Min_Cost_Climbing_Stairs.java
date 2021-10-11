package dp;

import challenge.sept2020.P007_Word_Pattern;

public class P00746_Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        P00746_Min_Cost_Climbing_Stairs soln = new P00746_Min_Cost_Climbing_Stairs();
        int[] cost = new int[]{10, 15, 20};
        int result = soln.minCostClimbingStairsRecursion(cost, cost.length);
        System.out.println(result);
        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        result = soln.minCostClimbingStairsRecursion(cost, cost.length);
        System.out.println(result);
        cost = new int[]{0, 0, 0, 1};
        result = soln.minCostClimbingStairsRecursion(cost, cost.length);
        System.out.println(result);
    }

    public int minCostClimbingStairsDP(int[] cost) {
        int m = cost.length;
        int[] dp = new int[m];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < m; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[m - 1], dp[m - 2]);
    }

    public int minCostClimbingStairsRecursion(int[] cost, int len) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int ret;
        if (len == 1) {
            ret = 0;
        } else if (len == 2) {
            ret = Math.min(cost[0], cost[1]);
        } else {
            int cost1 = minCostClimbingStairsRecursion(cost, len - 1) + cost[len - 1];
            int cost2 = minCostClimbingStairsRecursion(cost, len - 2) + cost[len - 2];
            ret = Math.min(cost1, cost2);
        }
        return ret;
    }
}
