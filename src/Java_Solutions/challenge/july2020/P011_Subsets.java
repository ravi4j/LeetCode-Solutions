package challenge.july2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P011_Subsets {
    public static void main(String[] args) {
        P011_Subsets solution = new P011_Subsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> results = solution.subsets(nums);
        results.stream().forEach(l -> System.out.println(l));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        generateSubSets(nums, results, subset, 0);
        return results;
    }

    private void generateSubSets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startAt) {
        results.add(new ArrayList<>(subset));

        for (int i = startAt; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubSets(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

}
