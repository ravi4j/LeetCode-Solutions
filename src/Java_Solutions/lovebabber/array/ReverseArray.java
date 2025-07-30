package lovebabber.array;

import java.util.Arrays;

/**
 * Given an array arr[], the task is to reverse the array. Reversing an array means rearranging the elements such that the first element becomes the last, the second element becomes second last and so on.
 *
 * Examples:
 *
 * Input: arr[] = {1, 4, 3, 2, 6, 5}
 * Output: {5, 6, 2, 3, 4, 1}
 * Explanation: The first element 1 moves to last position, the second element 4 moves to second-last and so on.
 *
 * Input: arr[] = {4, 5, 1, 2}
 * Output: {2, 1, 5, 4}
 * Explanation: The first element 4 moves to last position, the second element 5 moves to second last and so on.
 */
public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 6, 5};
		ReverseArray solution = new ReverseArray();
		solution.reverseArrayUsingTemporaryStorage(arr);
		System.out.println("Reversed array Using temporary storage: " + Arrays.toString(arr));
		solution.reverseArrayUsingTwoPointers(arr);
		System.out.println("Reversed array using two pointers: " + Arrays.toString(arr));
		solution.reverseArrayUsingTwoPointers(arr);
		System.out.println("Reversed array using swapping elements: "+ Arrays.toString(arr));
		solution.reverseArrayUsingRecursion(arr , 0, arr.length - 1);
		System.out.println("Reversed array using recursion: " +Arrays.toString(arr));
	}

	public void reverseArrayUsingTemporaryStorage(int[] arr) {
		if (arr == null || arr.length == 0) {
			return; // No need to reverse if the array is empty
		}
		int n = arr.length;
		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			temp[i] = arr[n - 1 - i]; // Copy elements in reverse order
		}

		for (int i = 0; i < n; i++) {
			arr[i] = temp[i]; // Copy back to original array
		}
	}

	public void reverseArrayUsingTwoPointers(int[] arr) {
		if (arr == null || arr.length == 0) {
			return; // No need to reverse if the array is empty
		}
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public void reverseArrayBySwappingElements(int[] arr) {
		if (arr == null || arr.length == 0) {
			return; // No need to` reverse if the array is empty
		}
		int n = arr.length;
		for (int i = 0; i < n/2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - 1 - i]; // Swap elements
			arr[n - 1 - i] = temp; // Swap elements
		}
	}

	public void reverseArrayUsingRecursion(int[] arr, int left, int right) {
		if (left >= right) {
			return; // Base case: if left index is greater than or equal to right index
		}
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp; // Swap elements
		reverseArrayUsingRecursion(arr, left + 1, right - 1); // Recursive call
	}

}
