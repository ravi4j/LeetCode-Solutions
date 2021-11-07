package pattern.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        NoRepeatSubstring solution = new NoRepeatSubstring();
        String str = "abbbb";
        int expect = 2;
        int actual = solution.findLength(str);
        assert expect == actual;
        System.out.println(actual);


        str = "abccde";
        expect = 3;
        actual = solution.findLength(str);
        assert expect == actual;
        System.out.println(actual);

        str = "aabccbb";
        expect = 3;
        actual = solution.findLength(str);
        assert expect == actual;
        System.out.println(actual);
    }

    public int findLength(String str) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightCh = str.charAt(windowEnd);
            // If character in map , then shrink the window
            if (freqMap.containsKey(rightCh)) {
                windowStart = Math.max(windowStart, freqMap.get(rightCh) + 1);
            }
            freqMap.put(rightCh, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
