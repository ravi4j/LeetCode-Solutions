import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P00120_Triangle {
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		int min = minimumTotal(triangle);
		System.out.println(min);
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		List<List<Integer>> dp = new ArrayList<List<Integer>>();
		int size = triangle.size();
		for (int i = 0; i < size - 1; i++) {
			dp.add(new ArrayList<Integer>());
		}
		dp.add(triangle.get(size - 1));
		for (int i = size - 2; i > -1; i--) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j < row.size(); j++) {
				int maxSumLeft = dp.get(i + 1).get(j);
				int maxSumRight = dp.get(i + 1).get(j + 1);
				int currentValue = row.get(j);
				int sumPath = currentValue + Math.min(maxSumLeft, maxSumRight);
			 	dp.get(i).add(sumPath);
			}
		}
		System.out.println(dp);
		return dp.get(0).get(0);

	}

}