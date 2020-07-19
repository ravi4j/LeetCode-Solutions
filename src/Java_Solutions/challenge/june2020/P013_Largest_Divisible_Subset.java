package challenge.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P013_Largest_Divisible_Subset {
    public static void main(String[] args) {
        P013_Largest_Divisible_Subset solution = new P013_Largest_Divisible_Subset();
        int[] nums = new int[]{1, 2, 3};
        List<Integer> list = solution.largestDivisibleSubset(nums);
        System.out.println(list);

        nums = new int[]{1, 2, 4, 8};
        list = solution.largestDivisibleSubset(nums);
        System.out.println(list);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        int[] subsetSize = new int[nums.length];
        int[] subsetStartIndex = new int[nums.length];
        Arrays.fill(subsetSize, 1);
        Arrays.fill(subsetStartIndex, -1);

        int maxSize = 0;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && subsetSize[i] < (1 + subsetSize[j])) {
                    subsetSize[i] = 1 + subsetSize[j];
                    subsetStartIndex[i] = j;
                }
            }

            if (maxSize < subsetSize[i]) {
                maxSize = subsetSize[i];
                maxIndex = i;
            }
        }
        // Follow Index to construct the largest subset
        int index = maxIndex;
        while (index >= 0) {
            result.add(nums[index]);
            index = subsetStartIndex[index];
        }
        return result;
    }

    public List<Integer> largestDivisibleSubsetDFS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (nums.length == 1) {
            return Arrays.asList(nums[0]);
        }
        Arrays.sort(nums);
        int[] max = new int[1];
        List<Integer> subset = new ArrayList<>();
        List<Integer> largestSubset = new ArrayList<>();
        largestDivisibleSubsetRecursive(nums, 0, subset, max, largestSubset);
        return largestSubset;
    }

    public void largestDivisibleSubsetRecursive(int[] nums, int start, List<Integer> subset, int[] max, List<Integer> largestSubset) {
        if (subset.size() > max[0]) {
            max[0] = subset.size();
            largestSubset.clear();
            largestSubset.addAll(subset);
        }

        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (subset.size() == 0) {
                subset.add(nums[i]);
                largestDivisibleSubsetRecursive(nums, i + 1, subset, max, largestSubset);
                subset.remove(subset.size() - 1);
            } else {
                int last = subset.get(subset.size() - 1);
                if (nums[i] % last == 0) {
                    subset.add(nums[i]);
                    largestDivisibleSubsetRecursive(nums, i + 1, subset, max, largestSubset);
                    subset.remove(subset.size() - 1);
                }
            }
        }
    }
}
