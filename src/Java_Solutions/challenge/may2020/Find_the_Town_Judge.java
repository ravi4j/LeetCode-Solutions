package challenge.may2020;

public class Find_the_Town_Judge {
    public static void main(String[] args) {
        Find_the_Town_Judge solution = new Find_the_Town_Judge();
        int N = 2;
        int[][] trust = new int[][]{{1, 2}};
        int result = solution.findJudge(N, trust);
        System.out.println(result);

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}};
        result = solution.findJudge(N, trust);
        System.out.println(result);

        N = 3;
        trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        result = solution.findJudge(N, trust);
        System.out.println(result);


        N = 3;
        trust = new int[][]{{1, 2}, {2, 3}};
        result = solution.findJudge(N, trust);
        System.out.println(result);


        N = 4;
        trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        result = solution.findJudge(N, trust);
        System.out.println(result);

    }

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];

        for (int[] edge : trust) {
            inDegree[edge[0]] -= 1;
            inDegree[edge[1]] += 1;
        }

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
