package pattern.slidingwindows.twopointers;

public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements solution = new RemoveElements();
        int[] arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        int key = 3;
        int expect = 4;
        int actual = solution.remove(arr, key);
        assert expect == actual;
        System.out.println(actual);

        arr = new int[]{2, 11, 2, 2, 1};
        key = 2;
        expect = 2;
        actual = solution.remove(arr, key);
        assert expect == actual;
        System.out.println(actual);

    }

    public int remove(int[] arr, int key) {
        int next = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] != key){
                arr[next] = arr[i];
                next++;
            }
        }
        return next;
    }
}
