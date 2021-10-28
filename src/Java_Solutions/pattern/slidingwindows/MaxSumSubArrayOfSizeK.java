package pattern.slidingwindows;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        MaxSumSubArrayOfSizeK solution = new MaxSumSubArrayOfSizeK();
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;
        int expect = 9;
        int actual = solution.findMaxSumSubArrayBySlidingWindow(k, arr);
        assert actual == expect;
        System.out.println(actual);
        actual = solution.findMaxSumSubArrayByBruteForce(k, arr);
        assert actual == expect;
        System.out.println(actual);
        k = 2;
        arr = new int[]{2, 3, 4, 1, 5};
        expect = 7;
        actual = solution.findMaxSumSubArrayBySlidingWindow(k, arr);
        assert actual == expect;
        System.out.println(actual);
        actual = solution.findMaxSumSubArrayByBruteForce(k, arr);
        assert actual == expect;
        System.out.println(actual);
    }

    // O(n*k)
    public int findMaxSumSubArrayByBruteForce(int k, int[] arr) {
        int maxSum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // O(n)
    public int findMaxSumSubArrayBySlidingWindow(int k, int[] arr) {
        int maxSum = 0;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}
