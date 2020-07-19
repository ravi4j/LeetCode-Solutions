package challenge.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P006_Queue_Reconstruction_by_Height {
    public static void main(String[] args) {
        P006_Queue_Reconstruction_by_Height solution = new P006_Queue_Reconstruction_by_Height();
        int[][] peoples = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = solution.reconstructQueue(peoples);
        System.out.println(Arrays.deepToString(queue));
    }


    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 2) {
            return people;
        }
        Arrays.sort(people, (P1, P2) -> {
            if (P1[0] == P2[0]) {
                return P1[1] - P2[1];
            }
            return P2[0] - P1[0];
        });
        List<int[]> temp = new ArrayList<>(people.length);
        for (int[] p : people) {
            temp.add(p[1], p);
        }
        return temp.toArray(new int[0][0]);
    }
}
