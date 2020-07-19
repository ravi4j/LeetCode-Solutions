package challenge.june2020;

import java.util.Arrays;

public class P007_Coin_Change_2 {
    public static void main(String[] args) {
        P007_Coin_Change_2 solution = new P007_Coin_Change_2();
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int result = solution.change(amount, coins);
        System.out.println(result); // 4

        amount = 3;
        coins = new int[]{2};
        result = solution.change(amount, coins);
        System.out.println(result); // 0

        amount = 10;
        coins = new int[]{10};
        result = solution.change(amount, coins);
        System.out.println(result); // 1

    }

    public int change(int amount, int[] coins) {
        // recursion
        //return  changeRecursion(amount , coins);
        // Improved recursion
        //return changeRecursion(amount, coins, coins.length);
        // Using Dynamic programing...bottom up
        //return changeDP(amount, coins);

        //return changeRecursion2(amount, coins, coins.length);

        return changeDP2(amount, coins);
    }

    public int changeRecursion(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        // pick last coin
        int val = coins[coins.length - 1];

        // maximum last coin can be included
        int n = amount / val;

        // Remove last coin from the set
        int[] remainingCoinSet = Arrays.copyOf(coins, coins.length - 1);

        int result = 0;
        for (int i = 0; i <= n; i++) {
            int remainingAmount = amount - i * val;
            result += changeRecursion(remainingAmount, remainingCoinSet);
        }
        return result;
    }

    // Improvement to avoid array copying
    public int changeRecursion(int amount, int[] coins, int size) {
        if (amount == 0) {
            return 1;
        }

        if (size == 0 || coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        // pick last coin
        int val = coins[size - 1];

        // maximum last coin can be included
        int n = amount / val;

        int result = 0;
        for (int i = 0; i <= n; i++) {
            int remainingAmount = amount - i * val;
            result += changeRecursion(remainingAmount, coins, size - 1);
        }
        return result;
    }

    /* Improved version using Dynamic programing to memorizing number of ways to have amount by using set coins[0...size-1]
      Use previous counts to next count  -- int countWays[amount][size]
    */
    // Improvement to avoid array copying
    private int changeDP(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int[][] dp = new int[amount + 1][coins.length + 1];

        //  only 1 way to have amount 0
        for (int i = 0; i <= coins.length; i++) {
            dp[0][i] = 1;
        }

        //no coin to pick, so no way to build
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = 0;
        }

        for (int targetAmount = 1; targetAmount <= amount; targetAmount++) {
            for (int size = 1; size <= coins.length; size++) {
                int val = coins[size - 1];
                int n = targetAmount / val;
                for (int j = 0; j <= n; j++) {
                    int remainingAmount = targetAmount - j * val;
                    if (remainingAmount >= 0) {
                        dp[targetAmount][size] += dp[remainingAmount][size - 1];
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[amount][coins.length];
    }

    // Recursion 2
    public int changeRecursion2(int amount, int[] coins, int size) {
        if (amount == 0) {
            return 1;
        }

        if (size == 0 || coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        // pick last coin
        int val = coins[size - 1];

        int contain = changeRecursion2(amount - val, coins, size);
        int not_contain = changeRecursion2(amount, coins, size - 1);
        return contain + not_contain;
    }


    // dp[amount - coin][size]  contains the coin + dp[amount][size - 1]  not contains
    private int changeDP2(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        int[][] dp = new int[amount + 1][coins.length + 1];

        //  only 1 way to have amount 0
        for (int i = 0; i <= coins.length; i++) {
            dp[0][i] = 1;
        }

        //no coin to pick, so no way to build
        for (int i = 1; i <= amount; i++) {
            dp[i][0] = 0;
        }

        for (int targetAmount = 1; targetAmount <= amount; targetAmount++) {
            for (int size = 1; size <= coins.length; size++) {
                int val = coins[size - 1];
                int contain = 0;
                if (targetAmount - val >= 0) {
                    contain = dp[targetAmount - val][size];
                }
                int not_contain = dp[targetAmount][size - 1];
                dp[targetAmount][size] = contain + not_contain;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[amount][coins.length];
    }

}
