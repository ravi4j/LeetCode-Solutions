package Java_Solutions.pattern.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinctCharacters {
	public static void main(String[] args) {
		LongestSubstringKDistinctCharacters solution = new LongestSubstringKDistinctCharacters();
		String s = "araaci";
		int K = 2;
		int expect = 4;
		int actual = solution.findLength(s, K);
		assert expect == actual;
		System.out.println(actual);

		s = "araaci";
		K = 1;
		expect = 2;
		actual = solution.findLength(s, K);
		assert expect == actual;
		System.out.println(actual);

		s = "cbbebi";
		K = 3;
		expect = 5;
		actual = solution.findLength(s, K);
		assert expect == actual;
		System.out.println(actual);
	}

	public int findLength(String s, int k) {
		if (s == null || s.length() == 0 || s.length() < k) {
			return -1;
		}
		Map<Character, Integer> characterFreqMap = new HashMap<>();
		int windowStart = 0;
		int maxLength = 0;
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightCh = s.charAt(windowEnd);
			characterFreqMap.merge(Character.valueOf(rightCh), 1, Integer::sum);
			while (characterFreqMap.size() > k) {
				char leftCh = s.charAt(windowStart);
				characterFreqMap.computeIfPresent(Character.valueOf(leftCh), (var key, var value) -> value - 1);
				if (characterFreqMap.get(leftCh) == 0) {
					characterFreqMap.remove(leftCh);
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
