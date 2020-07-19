package challenge.june2020;

import java.util.*;

public class P014_Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        P014_Cheapest_Flights_Within_K_Stops solution = new P014_Cheapest_Flights_Within_K_Stops();
        int n = 3;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int K = 1;
        int result = solution.findCheapestPrice(n, flights, src, dst, K);
        System.out.println(result); // 200

        n = 3;
        flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        src = 0;
        dst = 2;
        K = 0;
        result = solution.findCheapestPrice(n, flights, src, dst, K);
        System.out.println(result); // 500

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> flightGraph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] flight = flights[i];
            if (!flightGraph.containsKey(flight[0])) {
                flightGraph.put(flight[0], new HashMap<>());
            }
            flightGraph.get(flight[0]).put(flight[1], flight[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((A, B) -> Integer.compare(A[0], B[0]));
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] v = pq.poll();
            if (v[1] == dst) {
                return v[0]; // cost
            }
            if (v[2] >= 0) { // stops
                Map<Integer, Integer> adj = flightGraph.getOrDefault(v[1], new HashMap<>());
                for (int u : adj.keySet()) {
                    pq.offer(new int[]{v[0] + adj.get(u), u, K - 1});
                }
            }
        }
        return -1;
    }

    // DP - Bellman-Ford algorithm
    public int findCheapestPriceDP(int n, int[][] flights, int src, int dst, int K) {
        long[][] dp = new long[K + 2][n];
        for (long[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[0][src] = 0;
        for (int i = 1; i < K + 2; i++) {
            dp[i][src] = 0;
            for (int[] f : flights) {
                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i - 1][f[0]] + f[2]);
            }
        }
        return dp[K + 1][dst] == Integer.MAX_VALUE ? -1 : (int) dp[K + 1][dst];
    }
}
