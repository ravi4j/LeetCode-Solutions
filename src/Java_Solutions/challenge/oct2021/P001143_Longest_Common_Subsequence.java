package challenge.oct2021;

import java.util.HashMap;
import java.util.Map;

public class P001143_Longest_Common_Subsequence {

    public static void main(String[] args) {
        P001143_Longest_Common_Subsequence soln = new P001143_Longest_Common_Subsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int lenText1 = text1.length();
        int lenText2 = text2.length();
        System.out.println("Solved Using Recursion");
        int result = soln.longestCommonSubsequenceRecursive(text1, text2, lenText1, lenText2);
        System.out.println(result);
        System.out.println("Solved Using Memorization - Optimized Recursive");
        result = soln.longestCommonSubsequenceMemo(text1 , text2 , lenText1 , lenText2 , new HashMap<>());
        System.out.println(result);
        System.out.println("Solved Using Tabulation - Dynamic Programming");
        result = soln.longestCommonSubsequenceTabulation(text1 , text2);
        System.out.println(result);
    }

    // Dynamic Programming
    public int longestCommonSubsequenceTabulation(String text1, String text2) {
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

    public int longestCommonSubsequenceMemo(String text1, String text2, int lenText1, int lenText2, Map<String, Integer> memo) {
        if (lenText1 == 0 || lenText2 == 0) {
            return 0;
        }
        String key = lenText1 + "|" + lenText2;
        if (!memo.containsKey(key)) {
            if (text1.charAt(lenText1 - 1) == text2.charAt(lenText2 - 1)) {
                memo.put(key, 1 + longestCommonSubsequenceRecursive(text1, text2, lenText1 - 1, lenText2 - 1));
            } else {
                memo.put(key, Math.max(longestCommonSubsequenceRecursive(text1, text2, lenText1, lenText2 - 1)
                        , longestCommonSubsequenceRecursive(text1, text2, lenText1 - 1, lenText2)));
            }
        }
        return memo.get(key);
    }

    public int longestCommonSubsequenceRecursive(String text1, String text2, int lenText1, int lenText2) {
        if (lenText1 == 0 || lenText2 == 0) {
            return 0;
        }
        if (text1.charAt(lenText1 - 1) == text2.charAt(lenText2 - 1)) {
            return 1 + longestCommonSubsequenceRecursive(text1, text2, lenText1 - 1, lenText2 - 1);
        }
        return Math.max(longestCommonSubsequenceRecursive(text1, text2, lenText1, lenText2 - 1)
                , longestCommonSubsequenceRecursive(text1, text2, lenText1 - 1, lenText2));
    }
}
