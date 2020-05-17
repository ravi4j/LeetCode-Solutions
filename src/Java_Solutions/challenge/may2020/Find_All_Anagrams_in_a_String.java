package challenge.may2020;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String {

    public static void main(String[] args) {
        Find_All_Anagrams_in_a_String solution = new Find_All_Anagrams_in_a_String();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);

        s = "abab";
        p = "ab";
        result = solution.findAnagrams(s, p);
        System.out.println(result);

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        int[] freqP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] freqS = new int[26];
            for (int j = 0; j < p.length(); j++) {
                freqS[s.charAt(i + j) - 'a']++;
            }
            if (isMatch(freqS, freqP)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isMatch(int[] freqS, int[] freqP) {

        for (int i = 0; i < freqS.length; i++) {
            if (freqS[i] != freqP[i]) {
                return false;
            }
        }
        return true;
    }
}
