package challenge.april2020;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] input = {0, 2, 3,4, 1};
        MoveZeroes solution = new MoveZeroes();
        print(input);
        solution.moveZeroes(input);
        print(input);
    }

    private static void print(int[] input) {
        System.out.print("[ ");
        for (int a : input) {
            System.out.printf("%d ", a);
        }
        System.out.println("]");
    }

    // in-place with two pointers
    public void moveZeroes(int[] nums) {
        int i = 0;
        int s = 0;
        while (i < nums.length){
            if(s != i && nums[i] != 0){
                swap(nums , s , i);
                s++;
            }
            if(nums[i] != 0){
                s++;
            }
            i++;
        }
    }

    // with extra memory
    public void moveZeroes2(int[] nums) {
        int[] aux = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                aux[j++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
    }

    // in-place quadratic runtime
    public void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
