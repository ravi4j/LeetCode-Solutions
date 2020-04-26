package challenge.april2020;

public class Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Search_In_Rotated_Sorted_Array solution = new Search_In_Rotated_Sorted_Array();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = solution.search(nums, target);
        System.out.println(index);
        target = 3;
        index = solution.search(nums, target);
        System.out.println(index);

        nums = new int[]{7, 0, 1, 2, 3, 4, 5, 6};
        target = 0;
        index = solution.search(nums, target);
        System.out.println(index);
        target = 3;
        index = solution.search(nums, target);
        System.out.println(index);

        nums = new int[]{5 ,1 , 3};
        target =5;
        index = solution.search(nums, target);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                //System.out.println("pivot is on right of mid");
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
               // System.out.println("pivot is on left of mid");
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
