package pattern.slidingwindows;

public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        SmallestSubArrayWithGivenSum solution = new SmallestSubArrayWithGivenSum();
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
        int s = 7;
        int expect = 2;
        int actual = solution.findMinSubArrayByBruteForce(s, arr);
        assert expect == actual;
        System.out.println(actual);
        actual = solution.findMinSubArrayBySlidingWindow(s, arr);
        assert expect == actual;
        System.out.println(actual);
        arr = new int[]{2, 1, 5, 2, 8};
        expect = 1;
        actual = solution.findMinSubArrayByBruteForce(s, arr);
        assert expect == actual;
        System.out.println(actual);
        actual = solution.findMinSubArrayBySlidingWindow(s, arr);
        assert expect == actual;
        System.out.println(actual);
        arr = new int[]{3, 4, 1, 1, 6};
        s = 8;
        expect = 3;
        actual = solution.findMinSubArrayByBruteForce(s, arr);
        assert expect == actual;
        System.out.println(actual);
        actual = solution.findMinSubArrayBySlidingWindow(s, arr);
        assert expect == actual;
        System.out.println(actual);

    }

    public int findMinSubArrayByBruteForce(int s, int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int j = i + 1;
            while (sum < s && j < arr.length) {
                sum += arr[j++];
            }
            if (sum >= s) {
                min = Math.min(min, j - i);
            }
        }
        return min;
    }
    // Target sum is given not the window size, Use target s to determine the sliding window size.
    public int findMinSubArrayBySlidingWindow(int s, int[] arr) {
        int windowStart = 0;
        int windowSum = 0;
        int min = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            // shrink the window as small as possible until windowSum is smaller than target 's'
            while(windowSum >= s){
                min = Math.min(min , windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
