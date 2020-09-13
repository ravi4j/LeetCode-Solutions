package challenge.july2020;

public class P025_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        P025_Find_Minimum_in_Rotated_Sorted_Array solution = new P025_Find_Minimum_in_Rotated_Sorted_Array();
        int[] nums = new int[]{1, 3, 5};
        int result = solution.findMin(nums);
        System.out.println(result);

        nums = new int[]{2, 2, 2, 0, 1};
        result = solution.findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (nums[left] == nums[right] && left != right) {
                left++;
            }
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
