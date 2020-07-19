package challenge.july2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P003_Prison_Cells_After_N_Days {
    public static void main(String[] args) {
        P003_Prison_Cells_After_N_Days solution = new P003_Prison_Cells_After_N_Days();
        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        int[] result = solution.prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(result)); // [0,0,1,1,0,0,0,0]


        cells = new int[]{1, 0, 0, 1, 0, 0, 1, 0};
        N = 1000000000;
        result = solution.prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(result)); //  [0,0,1,1,1,1,1,0]
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> states = new HashMap<>();
        while (N > 0) {
            int[] temp = new int[8];
            states.put(Arrays.toString(cells), N);
            N--;
            for (int i = 1; i <= 6; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    temp[i] = 1;
                }
            }
            cells = temp;
            if (states.containsKey(Arrays.toString(cells))) {
                N %= states.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }
}
