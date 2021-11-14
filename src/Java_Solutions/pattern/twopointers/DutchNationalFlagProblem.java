package pattern.twopointers;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        DutchNationalFlagProblem solution = new DutchNationalFlagProblem();
        int[] arr = new int[]{1, 0, 2, 1, 0};
        solution.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 2, 0, 1, 2, 0};
        solution.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0){
                swap(arr , i , low);
                i++;
                low++;
            } else if(arr[i] == 1){
                i++;
            } else  if(arr[i] == 2){
                swap(arr , i , high);
                high--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
