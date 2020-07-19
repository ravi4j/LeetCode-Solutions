package challenge.july2020;

import java.util.*;

public class P018_Course_Schedule_II {
    private int label;
    private Map<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        P018_Course_Schedule_II solution =  new P018_Course_Schedule_II();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        int[] result = solution.findOrder(numCourses , prerequisites);
        System.out.println(Arrays.toString(result)); // [0,1]

        numCourses = 2;
        prerequisites = new int[][]{{0,1}};
        result = solution.findOrder(numCourses , prerequisites);
        System.out.println(Arrays.toString(result)); // [1,0]

        numCourses = 4;
        prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        result = solution.findOrder(numCourses , prerequisites);
        System.out.println(Arrays.toString(result)); // [0,1,2,3] or [0,2,1,3]

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        if(prerequisites.length == 0){
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        // 1. build graph
        this.label = 0;
        buildGraph(prerequisites);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(visited, result, i)) {
                return new int[0];
            }
        }
        return result;
    }

    public boolean hasCycle(int[] visited, int[] result, int node) {
        // Node Visited before has cycle
        if (visited[node] == -1) {
            return true;
        }
        // Node not part of cycle.
        if (visited[node] == 1) {
            return false;
        }

        visited[node] = -1;
        List<Integer> adj = graph.get(node);
        if (adj != null) {
            for (Integer next : adj) {
                if (hasCycle(visited, result, next)) {
                    return false;
                }
            }
        }
        // This node is not a part of cycle.
        result[this.label++] = node;
        visited[node] = 1;
        return false;
    }

    private void buildGraph(int[][] prerequisites) {
        this.graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> neighbours = graph.containsKey(prerequisites[i][0]) ? graph.get(prerequisites[i][0]) : new ArrayList<>();
            neighbours.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], neighbours);
        }
    }
}
