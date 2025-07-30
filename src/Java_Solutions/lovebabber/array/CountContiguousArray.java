package lovebabber.array;


/**
 you are given an array of integers arr. your task is to count the number of contiguous subarrays, such that elements of the subarray are arranged in strictly decreasing order.

for example, if arr = [9, 8, 4, 9, 3], then the subarray [9, 8, 4] meets the criteria (9 > 8 > 4), but the subarray [8, 4, 9] does not.

example

for arr = [9, 8, 7, 6, 5], the output should be solution(arr) = 15.

all contiguous subarrays satisfy the condition of problem, because all elements of the array are arranged in decreasing order. there are 15 possible contiguous subarrays, so the answer is 15.

for arr = [10, 10, 10], the output should be solution(arr) = 3.

since all of the elements are equal, the subarrays can't be in strictly decreasing order unless they contain only one element. there are 3 possible subarrays containing one element, so the answer is 3.

input/output

[execution time limit] 3 seconds (java)

[memory limit] 1 gb

[input] array.integer arr

an array of integers.

guaranteed constraints:
		1 ≤ arr.length ≤ 105,
		-109 ≤ arr[i] ≤ 109.

		[output] integer64

return the number of contiguous subarrays with elements in strictly decreasing order.
*/

public class CountContiguousArray {
	public static void main(String[] args) {
		int[] arr = {9, 8, 4, 9, 3};
		CountContiguousArray solution = new CountContiguousArray();
		System.out.println("Brute Force Count: " + solution.countDecreasingSubarrays(arr));
		System.out.println("Optimized Count: " + solution.optimized(arr));
		int[] arr1 = {9, 8, 7,6, 5};
		System.out.println("Brute Force Count: " + solution.countDecreasingSubarrays(arr1));
		System.out.println("Optimized Count: " + solution.optimized(arr1));
	}

	// Brute froce
	public int countDecreasingSubarrays(int[] arr) {
		int count = 0;
		int n = arr.length;
		// Check all possible subarrays
		for (int start = 0; start < n; start++) {
			for (int end = start; end < n; end++) {
				if (isDecreasing(arr, start, end)) {
					count++;
				}
			}
		}

		return count;
	}

	private boolean isDecreasing(int[] arr, int start, int end) {
		for (int i = start; i < end; i++) {
			if (arr[i] <= arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public long optimized(int[] arr) {
		long count = 0;
		int n = arr.length;
		int length = 1; // Start with a length of 1 for the first element

		for (int i = 1; i < n; i++) {
			if (arr[i] < arr[i - 1]) {
				length++; // Increase length if current element is less than previous
			} else {
				count += (length * (length + 1)) / 2; // Add the count of subarrays for the previous segment
				length = 1; // Reset length for the new segment
			}
		}

		// Add the last segment's count
		count += (length * (length + 1)) / 2;

		return count;
	}
}

