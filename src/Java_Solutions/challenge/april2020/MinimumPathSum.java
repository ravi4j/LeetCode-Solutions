package challenge.april2020;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        // Using DFS
        int result = solution.minPathSumUsingDfs(grid);
        System.out.println(result);

        // using DP
        result = solution.minPathSum(grid);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // initialized first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // initialized first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSumUsingDfs(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (i < m - 1 && j < n - 1) {
            int leftSum = grid[i][j] + dfs(grid, i, j + 1);
            int bottomSum = grid[i][j] + dfs(grid, i + 1, j);
            return Math.min(leftSum, bottomSum);
        }

        if (i < m - 1) {
            return grid[i][j] + dfs(grid, i + 1, j);
        }

        if (j < n - 1) {
            return grid[i][j] + dfs(grid, i, j + 1);
        }
        return 0;
    }

}
