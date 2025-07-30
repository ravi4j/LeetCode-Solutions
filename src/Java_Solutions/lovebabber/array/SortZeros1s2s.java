package lovebabber.array;

/**
 *Sort 0s, 1s and 2s
 * Difficulty: MediumAccuracy: 50.58%Submissions: 775K+Points: 4Average Time: 10m
 * Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 *
 * You need to solve this problem without utilizing the built-in sort function.
 *
 * Examples:
 *
 * Input: arr[] = [0, 1, 2, 0, 1, 2]
 * Output: [0, 0, 1, 1, 2, 2]
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 * Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
 * Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * Constraints:
 * 1 <= arr.size() <= 106
 * 0 <= arr[i] <= 2
 *
 *
 */
public class SortZeros1s2s {

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 0, 1, 2};
		sortArray(arr);
		System.out.println("Sorted array: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void sortArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return; // No need to sort if the array
		}
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;
		while (mid <= high){
		 			switch (arr[mid]) {
				case 0:
					// Swap arr[low] and arr[mid]
					swap(arr, low, mid);
					low++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					// Swap arr[mid] and arr[high]
					swap(arr, mid, high);
					high--;
					break;
			}
		}
		}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
