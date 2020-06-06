package challenge.may2020;

import java.util.*;

public class K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        K_Closest_Points_to_Origin solution = new K_Closest_Points_to_Origin();
        int K = 1;
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int[][] results = solution.kClosest(points, K);
        System.out.println(Arrays.deepToString(results));

        K = 2;
        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        results = solution.kClosest(points, K);
        System.out.println(Arrays.deepToString(results));

    }

    public int[][] kClosest(int[][] points, int K) {
        Map<Double, List<Integer>> distanceMap = new HashMap<>();
        Queue<Double> priorityQueue = new PriorityQueue();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double distance = Math.sqrt(Math.pow(point[1] - 0, 2) + Math.pow(point[0] - 0, 2));
            distanceMap.compute(distance, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            priorityQueue.offer(distance);
        }
        int[][] result = new int[K][2];
        int i = 0;
        while (!priorityQueue.isEmpty() && i < K) {
            List<Integer> pointIndexList = distanceMap.get(priorityQueue.poll());
            for (int j : pointIndexList) {
                result[i++] = points[j];
            }
        }
        return result;
    }
}
