package M1048LongestStringChain;

import java.util.*;

public class Solution {
    /**
     * Top down DP
     * Time: O(N * L^2), N is the number of words, L is the average length of words
     * Space: O(N)
     */
    public int longestStrChain(String[] words) {
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        Map<String, Integer> memo = new HashMap<>();
        int max = 0;
        for (String w : words) {
            max = Math.max(dfs(wordsPresent, memo, w), max);
        }
        return max;
    }

    private int dfs(Set<String> wordsPresent, Map<String, Integer> memo, String word) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        int max = 1;
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (wordsPresent.contains(newWord)) {
                max = Math.max(dfs(wordsPresent, memo, newWord) + 1, max);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, max);
        return max;
    }
}
