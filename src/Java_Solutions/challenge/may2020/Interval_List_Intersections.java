package challenge.may2020;

import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections {
    public static void main(String[] args) {
        Interval_List_Intersections solution = new Interval_List_Intersections();
        int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] result = solution.intervalIntersection(A, B);
        solution.printIntervals(result);
    }

    private void printIntervals(int[][] A) {
        System.out.print("[ ");
        for (int i = 0; i < A.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < A[i].length; j++) {
                System.out.printf("%d ", A[i][j]);
            }
            System.out.print("] ");
        }
        System.out.println(" ]");
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int a = 0, b = 0;
        while (a < A.length && b < B.length) {
            int tail = Math.min(A[a][1], B[b][1]);
            int head = Math.max(A[a][0], B[b][0]);
            if (head <= tail) {
                result.add(new int[]{head, tail});
            }
            if (A[a][1] == tail) {
                a += 1;
            }

            if (B[b][1] == tail) {
                b += 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
