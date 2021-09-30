import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P00187_Repeated_DNA_Sequences {
    public static void main(String[] args) {
        P00187_Repeated_DNA_Sequences solution = new P00187_Repeated_DNA_Sequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        System.out.println(result);
        s = "AAAAAAAAAAAAA";
        result = solution.findRepeatedDnaSequences(s);
        System.out.println(result);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        if (s == null || s.length() < 10) {
            return Collections.emptyList();
        }
        for (int i = 0; i <= s.length() - 10; i++) {
            String word = s.substring(i, i + 10);
            map.merge(word, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
