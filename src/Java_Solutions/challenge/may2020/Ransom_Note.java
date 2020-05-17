package challenge.may2020;

import java.util.HashMap;
import java.util.Map;

public class Ransom_Note {

    public static void main(String[] args) {
        Ransom_Note solution = new Ransom_Note();
        String ransomNote = "a";
        String magazine = "b";
        boolean result = solution.canConstruct(ransomNote, magazine);
        System.out.println(result);

        ransomNote = "aa";
        magazine = "ab";
        result = solution.canConstruct(ransomNote, magazine);
        System.out.println(result);

        ransomNote = "aa";
        magazine = "aab";
        result = solution.canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null && magazine == null) {
            return true;
        }
        if (ransomNote == null) {
            return true;
        }
        if (magazine == null) {
            return false;
        }
        if (ransomNote.length() == 0 && magazine.length() == 0) {
            return true;
        }
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            frequencyMap.merge(magazine.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (frequencyMap.containsKey(ch)) {
                if (frequencyMap.get(ch) > 1) {
                    frequencyMap.merge(ch, -1, Integer::sum);
                } else {
                    frequencyMap.remove(ch);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
