package pattern.slidingwindows.twopointers;

import java.util.Arrays;

public class SquaringSortedArray {
    public static void main(String[] args) {
        SquaringSortedArray solution = new SquaringSortedArray();
        int[] arr = new int[]{-2, -1, 0, 2, 3};
        int[] actual = solution.makeSquares(arr);
        System.out.println(Arrays.toString(actual));
        arr = new int[]{-3, -1, 0, 1, 2};
        actual = solution.makeSquares(arr);
        System.out.println(Arrays.toString(actual));
    }

    public int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int nextSqr = arr.length - 1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int lSqr = arr[left] * arr[left];
            int rSqr = arr[right] * arr[right];
            if (lSqr > rSqr) {
                squares[nextSqr--] = lSqr;
                left++;
            } else {
                squares[nextSqr--] = rSqr;
                right--;
            }
        }
        return squares;
    }
}
