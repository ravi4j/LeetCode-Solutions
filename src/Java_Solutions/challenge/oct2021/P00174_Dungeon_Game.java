package challenge.oct2021;

public class P00174_Dungeon_Game {
    public static void main(String[] args) {
        P00174_Dungeon_Game soln = new P00174_Dungeon_Game();
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        // int result = soln.calculateMinimumHPRecursive(dungeon);
        int result = soln.calculateMinimumHP(dungeon);
        System.out.println(result);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return -1;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    public int calculateMinimumHPRecursive(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return -1;
        }
        int[][] memo = new int[dungeon.length][dungeon[0].length];
        return calculateMinimumHPRecursiveHelper(dungeon, memo, 0, 0);
    }

    private int calculateMinimumHPRecursiveHelper(int[][] dungeon, int[][] memo, int x, int y) {
        if (x >= dungeon.length || y >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (memo[x][y] > 0) {
            return memo[x][y];
        }
        int minHealth = Integer.MAX_VALUE;
        minHealth = Math.min(minHealth, calculateMinimumHPRecursiveHelper(dungeon, memo, x + 1, y));
        minHealth = Math.min(minHealth, calculateMinimumHPRecursiveHelper(dungeon, memo, x, y + 1));

        if (x == m - 1 && y == n - 1) {
            minHealth = 1;
        }
        int finalMinHealth = minHealth <= dungeon[x][y] ? 1 : minHealth - dungeon[x][y];
        memo[x][y] = finalMinHealth;
        return finalMinHealth;
    }
}
