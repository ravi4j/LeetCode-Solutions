package Java_Solutions.pattern.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringProblemChallenge3 {
	public static void main(String[] args) {
		MinimumWindowSubstringProblemChallenge3 solution = new MinimumWindowSubstringProblemChallenge3();
		String str = "aabdec";
		String pattern = "abc";
		String expect = "abdec";
		String actual = solution.findSubstring(str, pattern);
		assert expect.equals(actual);
		System.out.println(actual);

		str = "abdabca";
		pattern = "abc";
		expect = "abc";
		actual = solution.findSubstring(str, pattern);
		assert expect.equals(actual);
		System.out.println(actual);

		str = "adcad";
		pattern = "abc";
		expect = "";
		actual = solution.findSubstring(str, pattern);
		assert expect.equals(actual);
		System.out.println(actual);

	}

	public String findSubstring(String str, String pattern) {
		int windowStart = 0;
		int matched = 0;
		int minLength = str.length() + 1;
		int subStart = 0;
		Map<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			freqMap.merge(pattern.charAt(i), 1, Integer::sum);
		}
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightCh = str.charAt(windowEnd);
			if (freqMap.containsKey(rightCh)) {
				freqMap.put(rightCh, freqMap.get(rightCh) - 1);
				if (freqMap.get(rightCh) >= 0) {
					matched++;
				}
			}
			// Shrink Window
			while (matched == pattern.length()) {
				int windowSize = windowEnd - windowStart + 1;
				if (minLength > windowSize) {
					minLength = windowSize;
					subStart = windowStart;
				}
				char leftCh = str.charAt(windowStart);
				windowStart++;
				if (freqMap.containsKey(leftCh)) {
					if (freqMap.get(leftCh) == 0) {
						matched--;
					}
					freqMap.put(leftCh, freqMap.get(leftCh) + 1);
				}
			}
		}
		return minLength > str.length() ? "" : str.substring(subStart, subStart + minLength);
	}
}
