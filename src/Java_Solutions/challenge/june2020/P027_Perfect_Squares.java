package challenge.june2020;

import java.util.Arrays;

public class P027_Perfect_Squares {

    public static void main(String[] args) {
        P027_Perfect_Squares solution = new P027_Perfect_Squares();
        int n = 12;
        int result = solution.numSquares(n);
        System.out.println(result); //  4 + 4 + 4 : Answer 3

        n = 13;
        result = solution.numSquares(n);
        System.out.println(result); // 4 + 9 : Answer 2

        n = 25;
        result = solution.numSquares(n);
        System.out.println(result); // 4 + 9 : Answer 2
    }

    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max; j++) {
                if ((j * j) == i) {
                    dp[i] = 1;
                } else if (i > (j * j)) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

    // Lagrange’s Four-Square Theorem
    //every natural number can be represented as the sum of four integer squares
    //and
    //a positive integer can be expressed as the sum of three squares if and only if it is not of the form 4^k(8m+7) for integers k and m
    public int numSquaresTheorem(int n) {
        int k = n;
        while (k % 4 == 0) {
            k = k / 4;
        }

        if (k % 8 == 7) {
            return 4;
        }

        //find if less than three
        int i = 0;
        int i_square = (int) Math.pow(i, 2);
        while (i_square <= n) {
            int j = 0;
            int j_square = (int) Math.pow(j, 2);
            while (j_square <= n - i_square) {
                if (i_square + j_square == n) {
                    return (i > 1 ? 1 : 0) + (j > 1 ? 1 : 0);
                }
                j++;
                j_square = (int) Math.pow(j, 2);
            }
            i++;
            i_square = (int) Math.pow(i, 2);
        }
        return 3;
    }

}
