package challenge.april2020;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int result = solution.lastStoneWeight(stones);
        System.out.println(result);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxQueue.add(stones[i]);
        }
        while (maxQueue.size() > 1) {
            int y = maxQueue.poll();
            int x = maxQueue.poll();
            if (x != y) {
                int remaining = Math.abs(y - x);
                maxQueue.add(remaining);
            }
        }
        return maxQueue.size() == 1 ? maxQueue.poll() : 0;
    }

}
