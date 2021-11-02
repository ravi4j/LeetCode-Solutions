package pattern.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        int expect = 4;
        int actual = solution.remove(arr);
        assert expect == actual;
        System.out.println(actual);
        arr = new int[]{2, 2, 2, 11};
        expect = 2;
        actual = solution.remove(arr);
        assert expect == actual;
        System.out.println(actual);
    }

    public int remove(int[] arr) {
        int nonDuplicateNext = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nonDuplicateNext - 1] != arr[i]) {
                arr[nonDuplicateNext] = arr[i];
                nonDuplicateNext++;
            }
        }
        return nonDuplicateNext;
    }

}
