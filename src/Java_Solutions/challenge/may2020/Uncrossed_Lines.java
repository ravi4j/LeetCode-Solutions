package challenge.may2020;

public class Uncrossed_Lines {
    public static void main(String[] args) {
        Uncrossed_Lines solution = new Uncrossed_Lines();
        int[] A = new int[]{1, 4, 2};
        int[] B = new int[]{1, 2, 4};
        int result = solution.maxUncrossedLines(A, B);
       // result = solution.maxUncrossedLinesRecursive(A, B);
        System.out.println(result); //2

        A = new int[]{2, 5, 1, 2, 5};
        B = new int[]{10, 5, 2, 1, 5, 2};
        result = solution.maxUncrossedLines(A, B);
       // result = solution.maxUncrossedLinesRecursive(A, B);
        System.out.println(result); // 3

        A = new int[]{1, 3, 7, 1, 7, 5};
        B = new int[]{1, 9, 2, 5, 1};
        result = solution.maxUncrossedLines(A, B);
       // result = solution.maxUncrossedLinesRecursive(A, B);
        System.out.println(result); // 3
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }


    public int maxUncrossedLinesRecursive(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        Integer[][] memorized = new Integer[A.length][B.length];
        int max = maxUncrossedLinesRecursive(A, B, 0, 0, memorized);
        return max;
    }

    public int maxUncrossedLinesRecursive(int[] A, int[] B, int a, int b, Integer[][] memorized) {
        if (a >= A.length || b >= B.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        if (memorized[a][b] != null) {
            return memorized[a][b];
        }
        if (A[a] == B[b]) {
            max = maxUncrossedLinesRecursive(A, B, a + 1, b + 1, memorized) + 1;
        }
        max = Math.max(max, maxUncrossedLinesRecursive(A, B, a + 1, b, memorized));
        max = Math.max(max, maxUncrossedLinesRecursive(A, B, a, b + 1, memorized));
        memorized[a][b] = max == Integer.MIN_VALUE ? 0 : max;
        return max;
    }

}
