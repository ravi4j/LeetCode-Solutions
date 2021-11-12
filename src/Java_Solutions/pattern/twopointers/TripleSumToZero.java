package pattern.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleSumToZero {
    public static void main(String[] args) {
        TripleSumToZero solution = new TripleSumToZero();
        int[] arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> actual = solution.searchTriplets(arr);
        System.out.println(actual);

        arr = new int[]{-5, 2, -1, -2, 3};
        actual = solution.searchTriplets(arr);
        System.out.println(actual);
    }

    public List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // X + Y  = -Z , so target is -Z
            searchPair(arr, -arr[i], i + 1, results);
        }
        return results;
    }

    public void searchPair(int[] arr, int target, int index, List<List<Integer>> result) {
        int left = index;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                result.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if( target > currentSum){
                left++;
            } else {
                right--;
            }
        }

    }
}
