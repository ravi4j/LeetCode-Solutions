package pattern.slidingwindows;

import java.util.*;

public class WordConcatenationProblemChallenge4 {
    public static void main(String[] args) {
        WordConcatenationProblemChallenge4 solution = new WordConcatenationProblemChallenge4();
        String str = "catfoxcat";
        String[] words = new String[]{"cat", "fox"};
        List<Integer> actual = solution.findWordConcatenation(str, words);
        System.out.println(actual);

        str = "catcatfoxfox";
        words = new String[]{"cat", "fox"};
        actual = solution.findWordConcatenation(str, words);
        System.out.println(actual);

    }

    public List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> freqWord = new HashMap<>();
        for (String word : words) {
            freqWord.merge(word, 1, Integer::sum);
        }
        int wordLength = words[0].length();
        int wordCount = words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= str.length() - wordCount * wordLength; i++) {
            Map<String, Integer> wordSeen = new HashMap<>();
            for (int j = 0; j < wordCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!freqWord.containsKey(word)) {
                    break;
                }
                wordSeen.put(word, wordSeen.getOrDefault(word, 0) + 1);
                if (wordSeen.get(word) > freqWord.getOrDefault(word, 0)) {
                    break;
                }
                if (j + 1 == wordCount) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
