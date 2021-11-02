package Java_Solutions.pattern.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
	public static void main(String[] args) {
		CharacterReplacement solution = new CharacterReplacement();
		String str = "aabccbb";
		int k = 2;
		int expect = 5;
		int actual = solution.findLength(str , k);
		assert  expect == actual;
		System.out.println(actual);

		str = "abbcb";
		k = 1;
		expect = 4;
		actual = solution.findLength(str , k);
		assert  expect == actual;
		System.out.println(actual);

		str = "abccde";
		k = 1;
		expect = 3;
		actual = solution.findLength(str , k);
		assert  expect == actual;
		System.out.println(actual);
	}

	public int findLength(String str , int k){
		int maxRepeatingCharacterCount = 0;
		int maxLength = 0;
		int windowStart = 0;
		Map<Character , Integer> freqMap =  new HashMap<>();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			freqMap.merge(rightChar , 1 , Integer::sum);
			maxRepeatingCharacterCount = Math.max(maxRepeatingCharacterCount , freqMap.get(rightChar));
			// if remaining chars are more than 'k' , shrink Window
			while((windowEnd - windowStart + 1) - maxRepeatingCharacterCount > k){
				char leftCh = str.charAt(windowStart);
				freqMap.computeIfPresent(leftCh , (var key, var value) -> value - 1);
				windowStart++;
			}
			maxLength = Math.max(maxLength ,  windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
