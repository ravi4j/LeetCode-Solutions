class P00115_DistinctSubsequences    {
	public static void main(String[] args) {
		String source = "rabbbit";
		String target = "rabbit";
		int num = numDistinct(source, target);
		System.out.println(num);
	}

	public static int numDistinct(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return 0;
		}
		int n = s.length();
		int m = t.length();
		int[][] total = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			total[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					total[i][j] += total[i - 1][j] + total[i - 1][j - 1];
				} else {
					total[i][j] += total[i - 1][j];
				}
			}
		}
		debug(s, t, total);
		return total[n][m];
	}

	public static void debug(String s, String t, int[][] matrix) {
		System.out.print("     ");
		for (int i = 0; i <= t.length(); i++) {
			if (i > 0) {
				System.out.print(" " + t.charAt(i - 1));
			}
		}
		System.out.println();
		for (int i = 0; i < s.length() + 1; i++) {
			String rowPrefix = "  ";
			if(i < matrix.length) {
				 rowPrefix = i > 0 ? s.charAt(i - 1) + " " : "  ";
			}
			System.out.print(rowPrefix + "  ");
			for (int j = 0; j < t.length() + 1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}