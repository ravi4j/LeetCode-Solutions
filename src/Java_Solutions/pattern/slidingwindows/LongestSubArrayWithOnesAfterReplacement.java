package pattern.slidingwindows;

public class LongestSubArrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        LongestSubArrayWithOnesAfterReplacement solution = new LongestSubArrayWithOnesAfterReplacement();
        int[] arr = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        int expect = 6;
        int actual = solution.findLength(arr, k);
        assert expect == actual;
        System.out.println(actual);

        arr = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        k = 3;
        expect = 9;
        actual = solution.findLength(arr, k);
        assert expect == actual;
        System.out.println(actual);

    }

    public int findLength(int[] arr, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxOnesCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnesCount++;
            }
            if ((windowEnd - windowStart + 1) - maxOnesCount > k) {
                if (arr[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

}
