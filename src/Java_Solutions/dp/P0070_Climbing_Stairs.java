package dp;

import java.util.HashMap;
import java.util.Map;

public class P0070_Climbing_Stairs {
    public static void main(String[] args) {
        P0070_Climbing_Stairs soln = new P0070_Climbing_Stairs();
        int n = 2;
        int result = soln.climbStairsRecursiveWithMemo(n);
        System.out.println(result);
        n = 4;
        result = soln.climbStairsRecursiveWithMemo(n);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        if(n <=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsRecursiveWithMemo(int n) {
        return climbStairsHelper(n, new HashMap<>());

    }

    private int climbStairsHelper(int n , Map<Integer , Integer> mem) {
        int result;

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        if(!mem.containsKey(n)) {
            result = climbStairsHelper(n - 1, mem) + climbStairsHelper(n - 2, mem);
            mem.put(n, result);
        }
        return mem.get(n);
    }
}
