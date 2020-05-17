package challenge.may2020;

import java.util.HashSet;
import java.util.Set;

public class Jewels_and_Stones {
    public static void main(String[] args) {
        Jewels_and_Stones solution = new Jewels_and_Stones();
        String J = "aA";
        String S = "aAAbbbbb";
        int result = solution.numJewelsInStones(J, S);
        System.out.println(result);

        J= "z";
        S = "ZZZZ";
        result = solution.numJewelsInStones(J, S);
        System.out.println(result);
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        Set<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewelSet.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewelSet.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
