package lovebabber.array;

/**
 * * Given an array of integers, find the minimum and maximum elements in the array.
 Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

 Examples:

 Input: arr[] = {3, 5, 4, 1, 9}
 Output: Minimum element is: 1
 Maximum element is: 9

 Input: arr[] = {22, 14, 8, 17, 35, 3}
 Output:  Minimum element is: 3
 Maximum element is: 35

  Solution 1 : Sorting n * log(n)
  Solution 2: Linear Search O(n)
  Solution 3:Tournament Method 	O(log(n))
  Solution 4: Pairwise Comparison O(n)
 */
public class FindMinMax {
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 1, 9};
		int[] result = findMinMaxUsinglinearSearch(arr);
		System.out.println("Minimum element is: " + result[0]);
		System.out.println("Maximum element is: " + result[1]);
		int[] result2 = findMinMaxUsingPairwiseComparison(arr);
		System.out.println("Minimum element is: " + result2[0]);
		System.out.println("Maximum element is: " + result2[1]);
		int[] result3 = findMinMaxUsingTournamentMethod(arr);
		System.out.println("Minimum element is: " + result3[0]);
		System.out.println("Maximum element is: " + result3[1]);
	}

	public static int[] findMinMaxUsinglinearSearch(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array cannot be null or empty");
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int num : arr) {
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}

		return new int[]{min, max};
	}

	public static int[] findMinMaxUsingPairwiseComparison(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array cannot be null or empty");
		}

		int min, max;
		if (arr.length % 2 == 0) {
			if (arr[0] < arr[1]) {
				min = arr[0];
				max = arr[1];
			} else {
				min = arr[1];
				max = arr[0];
			}
		} else {
			min = max = arr[0];
		}

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > max) {
				max = arr[i];
			}
		}
		return new int[]{
			min, max
		} ;
	}

	public static int[] findMinMaxUsingTournamentMethod(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array cannot be null or empty");
		}
		return findMinMax(arr, 0, arr.length - 1);
	}

	private static  int[] findMinMax(int[] arr, int left, int right) {
		if (left == right) {
			return new int[]{arr[left], arr[left]};
		}

		if (right - left == 1) {
			if (arr[left] < arr[right]) {
				return new int[]{arr[left], arr[right]};
			} else {
				return new int[]{arr[right], arr[left]};
			}
		}

		int mid = (left + right) / 2;
		int[] leftResult = findMinMax(arr, left, mid);
		int[] rightResult = findMinMax(arr, mid + 1, right);

		int min = Math.min(leftResult[0], rightResult[0]);
		int max = Math.max(leftResult[1], rightResult[1]);

		return new int[]{min, max};
	}


}
