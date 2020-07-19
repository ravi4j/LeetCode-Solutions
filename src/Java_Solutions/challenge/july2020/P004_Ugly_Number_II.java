package challenge.july2020;

import java.util.ArrayList;
import java.util.List;

public class P004_Ugly_Number_II {
    public static void main(String[] args) {
        P004_Ugly_Number_II solution = new P004_Ugly_Number_II();
        int n = 10;
        int result = solution.nthUglyNumber(n);
        System.out.println(result);
    }


    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        result.add(1);
        int i = 0, j = 0, k = 0;
        while (result.size() < n) {
            int L1 = result.get(i) * 2;
            int L2 = result.get(j) * 3;
            int L3 = result.get(k) * 5;
            int min = Math.min(L1, Math.min(L2, L3));
            result.add(min);
            if (min == L1) i++;
            if (min == L2) j++;
            if (min == L3) k++;
        }
        return result.get(result.size() - 1);
    }
}
