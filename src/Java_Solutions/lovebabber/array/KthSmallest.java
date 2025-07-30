package lovebabber.array;

/**
 * Given an array arr[] and an integer k where k is smaller than the size of the array,
 * your task is to find the kth smallest element in the given array.
 *
 * Follow up: Don't solve it using the inbuilt sort function.
 *
 * Examples :
 *
 * Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
 * Output: 7
 * Explanation: 3rd smallest element in the given array is 7.
 * Input: arr[] = [2, 3, 1, 20, 15], k = 4
 * Output: 15
 * Explanation: 4th smallest element in the given array is 15.
 * Constraints:
 * 1 <= arr.size <= 106
 * 1<= arr[i] <= 106
 * 1 <= k <= n
 */

public class KthSmallest {

	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 3, 20, 15};
		int k = 3;
		int result = kthSmallest(arr, k);
		System.out.println(k + "th smallest element is: " + result);
	}

	public static int kthSmallest(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			throw new IllegalArgumentException("k is out of bounds");
		}
		return quickSelect(arr, 0, arr.length - 1, k );
	}

	// This method will be used to partition the array around a pivot
	// and return the index of the pivot after partitioning.
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right]; // Choosing the last element as pivot
		int i = left - 1; // Pointer for the smaller element
		for (int j= left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++; // Increment index of smaller element
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// Swap the pivot element with the element at i+1
		int temp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = temp;
		//print array element after partitioning
		System.out.print("Array after partitioning: " + java.util.Arrays.toString(arr));
		System.out.println(" Pivot index: " + (i + 1));
		return i+1; // Return the index of the pivot element
	}
	public static int quickSelect(int[] arr , int left, int right, int k){
		if (left <= right) {
			int pivotIndex = partition(arr, left, right);
			if (pivotIndex == k - 1) {
				return arr[pivotIndex]; // Found the kth smallest element
			} else if (pivotIndex > k) {
				return quickSelect(arr, left, pivotIndex - 1, k); // Search in the left subarray
			} else {
				return quickSelect(arr, pivotIndex + 1, right, k); // Search in the right subarray
			}
		}
		return -1;
	}


}
