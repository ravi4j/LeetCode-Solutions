package pattern.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAStringProblemChallenge1 {
    public static void main(String[] args) {
        PermutationInAStringProblemChallenge1 solution = new PermutationInAStringProblemChallenge1();
        String str = "oidbcaf";
        String pattern = "abc";
        boolean expect = true;
        boolean actual = solution.findPermutation(str, pattern);
        assert expect == actual;
        System.out.println(actual);

        str = "odicf";
        pattern = "dc";
        expect = false;
        actual = solution.findPermutation(str, pattern);
        assert expect == actual;
        System.out.println(actual);

        str = "bcdxabcdy";
        pattern = "bcdyabcdx";
        expect = true;
        actual = solution.findPermutation(str, pattern);
        assert expect == actual;
        System.out.println(actual);

        str = "aaacb";
        pattern = "abc";
        expect = true;
        actual = solution.findPermutation(str, pattern);
        assert expect == actual;
        System.out.println(actual);

    }

    public boolean findPermutation(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> pFreqMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            pFreqMap.merge(pattern.charAt(i), 1, Integer::sum);
        }
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightCh = str.charAt(windowEnd);
            if (pFreqMap.containsKey(rightCh)) {
                pFreqMap.put(rightCh, pFreqMap.get(rightCh) - 1);
                if (pFreqMap.get(rightCh) == 0) {
                    matched++;
                }
            }
            if (matched == pFreqMap.size()) {
                return true;
            }
            // shrink the window if size is greater than pattern size
            if (windowEnd >= pattern.length() - 1) {
                char leftCh = str.charAt(windowStart);
                windowStart++;
                if (pFreqMap.containsKey(leftCh)) {
                    if (pFreqMap.get(leftCh) == 0) {
                        matched--;
                    }
                    pFreqMap.put(leftCh, pFreqMap.get(leftCh) + 1);
                }
            }
        }
        return false;
    }
}
