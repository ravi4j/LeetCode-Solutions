package challenge.june2020;

import java.util.ArrayList;
import java.util.List;

public class P020_Permutation_Sequence {
    public static void main(String[] args) {
        P020_Permutation_Sequence solution = new P020_Permutation_Sequence();
        int n = 3;
        int k = 3;
        String result = solution.getPermutation(n, k);
        System.out.println(result); // "213"


        n = 4;
        k = 9;
        result = solution.getPermutation(n, k);
        System.out.println(result); // "2314"

    }

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        char[] str = new char[n];

        factorial[0] = 1;
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= i;
            factorial[i] = p;
        }

        List<Integer> digits = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }

        k--;

        for (int i = 0; i < n; i++) {
            int index = k / factorial[n - i - 1];
            str[i] = (char) ('0' + digits.get(index));
            digits.remove(index);
            k %= factorial[n - i - 1];
        }
        return new String(str);
    }
}
