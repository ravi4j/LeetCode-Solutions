package Java_Solutions.pattern.slidingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagramsProblemChallenge2 {
	public static void main(String[] args) {
		StringAnagramsProblemChallenge2 solution = new StringAnagramsProblemChallenge2();
		String str = "ppqp";
		String pattern = "pq";
		List<Integer> actual = solution.findStringAnagrams(str , pattern);
		System.out.println(actual);

		str = "abbcabc";
		pattern = "abc";
		actual = solution.findStringAnagrams(str , pattern);
		System.out.println(actual);

	}

	public List<Integer> findStringAnagrams(String str , String pattern){
		int windowStart = 0;
		int matched = 0;
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> pFreqMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			pFreqMap.merge(pattern.charAt(i), 1, Integer::sum);
		}
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightCh = str.charAt(windowEnd);
			if (pFreqMap.containsKey(rightCh)) {
				pFreqMap.put(rightCh, pFreqMap.get(rightCh) - 1);
				if (pFreqMap.get(rightCh) == 0) {
					matched++;
				}
			}
			if (matched == pFreqMap.size()) {
				result.add(windowStart);
			}
			// shrink the window if size is greater than pattern size
			if (windowEnd >= pattern.length() - 1) {
				char leftCh = str.charAt(windowStart);
				windowStart++;
				if (pFreqMap.containsKey(leftCh)) {
					if (pFreqMap.get(leftCh) == 0) {
						matched--;
					}
					pFreqMap.put(leftCh, pFreqMap.get(leftCh) + 1);
				}
			}
		}
		return result;
	}
}
