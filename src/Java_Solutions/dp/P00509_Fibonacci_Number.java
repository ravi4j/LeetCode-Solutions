package dp;

public class P00509_Fibonacci_Number {
    public static void main(String[] args) {
        P00509_Fibonacci_Number soln = new P00509_Fibonacci_Number();
        System.out.println("\nTabulation");
        long start = System.currentTimeMillis();
        for (int i = 2; i < 5; i++) {
            int result = soln.fib(i);
            System.out.print(result + " ");
        }
        System.out.println("\nTime taken..." + (System.currentTimeMillis() - start));
        System.out.println("\nRecursion");
        start = System.currentTimeMillis();
        for (int i = 2; i < 5; i++) {
            int result = soln.fibRecursive(i);
            System.out.print(result + " ");
        }
        System.out.println("\nTime taken..." + (System.currentTimeMillis() - start));
        System.out.println("\nRecursion with Memo");
        start = System.currentTimeMillis();
        for (int i = 2; i < 5; i++) {
            int result = soln.fibRecursiveWithMemo(i, new int[i + 1]);
            System.out.print(result + " ");
        }
        System.out.println("\nTime taken..." + (System.currentTimeMillis() - start));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fibRecursiveWithMemo(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        memo[0] = 0;
        memo[1] = 1;
        if (memo[n] == 0) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }

    public int fibRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
