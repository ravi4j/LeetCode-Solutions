import java.util.Random;
import java.util.stream.IntStream;

class P00384_Shuffle_An_Array {
	private int[] original;
	private int[] shuffle;
	private int size;

	public P00384_Shuffle_An_Array(int[] nums) {
		this.original = nums;
		this.size = nums.length;
		this.shuffle = nums.clone();
	}

	/**
	 * Resets the array to its original configuration and return it.
	 */
	public int[] reset() {
		return this.original;
	}

	/**
	 * Returns a random shuffling of the array.
	 */
	public int[] shuffle() {
		Random random = new Random();
		int target = -1;
		for (int i = 0; i < size; i++) {
			target = random.nextInt(size - i) + i;
			swap(shuffle, i, target);
		}
		return shuffle;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		P00384_Shuffle_An_Array solution = new P00384_Shuffle_An_Array(nums);
		IntStream.of(solution.shuffle()).forEach(i->System.out.print(i +" "));
	}

}

