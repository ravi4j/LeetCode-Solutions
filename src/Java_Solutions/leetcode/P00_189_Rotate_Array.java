package leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class P00_189_Rotate_Array {

	public static void main(String[] args) {
		P00_189_Rotate_Array solution = new P00_189_Rotate_Array();
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		solution.rotateUsingBruteForce
				(nums, k);
		System.out.println(Arrays.toString(nums));
		int[] nums1 = new int[] {-1, -100, 3, 99};
		int k1 = 2;
		solution.rotateUsingExtraStorage(nums1, k1);
		System.out.println(Arrays.toString(nums1));
	}

	/**
	 * O(n) time complexity
	 * O(1) space complexity
	 */
	public void rotateWithReverse(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	/**
	 * O(n*k) time complexity
	 * O(1) space complexity
	 */
	public void rotateUsingBruteForce(int[] nums, int k) {
		for (int j = 0; j < k; j++) {
			int temp = nums[nums.length - 1];
			// move all the elements to the right
			for (int l = nums.length - 1; l > 0; l--) {
				nums[l] = nums[l - 1];
			}
			nums[0] = temp;
		}
	}

	/**
	 * O(n) time complexity
	 * O(n) space complexity
	 */
	public void rotateUsingExtraStorage(int[] nums, int k) {
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[(i + k) % nums.length] = nums[i];
		}
		System.arraycopy(a, 0, nums, 0, nums.length);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
