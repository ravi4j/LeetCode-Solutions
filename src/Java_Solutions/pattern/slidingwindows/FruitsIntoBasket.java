package Java_Solutions.pattern.slidingwindows;

import java.util.HashMap;
import java.util.Map;

// Max Fruits count of two types
public class FruitsIntoBasket {
	public static void main(String[] args) {
		FruitsIntoBasket solution = new FruitsIntoBasket();
		// TEST CASE 1
		char[] fruit = new char[] { 'A', 'B', 'C', 'A', 'C' };
		//Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
		int expect = 3;
		int actual = solution.findLength(fruit);
		assert expect == actual;
		System.out.println(actual);
		// TEST CASE 2
		fruit = new char[] { 'A', 'B', 'C', 'B', 'B', 'C' };
		 /*	Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
		  This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
	    */
		expect = 5;
		actual = solution.findLength(fruit);
		assert expect == actual;
		System.out.println(actual);
	}

	public int findLength(char[] chars) {
		int windowStart = 0;
		int maxLength = 0;
		Map<Character, Integer> freqMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < chars.length; windowEnd++) {
			char rightCh = chars[windowEnd];
			freqMap.merge(rightCh, 1, Integer::sum);
			// if  Fruits is more than two , shrink the window
			if (freqMap.size() > 2) {
				char leftCh = chars[windowStart];
				freqMap.computeIfPresent(leftCh, (var key, var value) -> value - 1);
				if (freqMap.get(leftCh) == 0) {
					freqMap.remove(leftCh);
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
