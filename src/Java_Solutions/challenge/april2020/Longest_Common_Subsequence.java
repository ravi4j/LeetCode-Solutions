package challenge.april2020;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        Longest_Common_Subsequence solution = new Longest_Common_Subsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result);

        text1 = "abc";
        text2 = "abc";
        result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result);

        text1 = "abc";
        text2 = "def";
        result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
