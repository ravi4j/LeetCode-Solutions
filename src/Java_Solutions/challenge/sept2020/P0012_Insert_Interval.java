package challenge.sept2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0012_Insert_Interval {
    public static void main(String[] args) {
        P0012_Insert_Interval solution = new P0012_Insert_Interval();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] result = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result)); // [[1,5],[6,9]]

        intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        newInterval = new int[]{4, 8};
        result = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result)); // [[1,2],[3,10],[12,16]]

        intervals = new int[][]{};
        newInterval = new int[]{5, 7};
        result = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result)); // [[5,7]]

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{6, 8};
        result = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result)); // [[1,5],[6,8]]
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> result = new ArrayList<>();
        int start = binarySearch(intervals, newInterval);
        for (int i = 0; i < start; i++) {
            result.add(intervals[i]);
        }
        for (int i = start; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval[1] >= newInterval[0] || interval[0] <= newInterval[1]) {
                newInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            }
        }
        result.add(newInterval);
        int[][] resultArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private int binarySearch(int[][] intervals, int[] newInterval) {
        int low = 0;
        int high = intervals.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (newInterval[0] <= intervals[mid][0]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high == 0 ? 0 : high - 1;
    }
}
