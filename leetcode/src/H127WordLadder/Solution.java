package H127WordLadder;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(N * L^2) 59ms 84.8%
     * Space Complexity O(L^2 * N) 50.4MB 14.43%
     */
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int len = beginWord.length();
//        Map<String, List<String>> map = new HashMap<>();
//        //
//        for (String word : wordList) {
//            for (int i = 0; i < len; i++) {
//                String replace = word.substring(0, i) + "*" + word.substring(i + 1, len);
//                if (!map.containsKey(replace)) {
//                    map.put(replace, new ArrayList<>());
//                }
//                map.get(replace).add(word);
//            }
//        }
//
//        Queue<Pair<String, Integer>> q = new LinkedList<>();
//        Set<String> visited = new HashSet<>();
//
//        q.add(new Pair(beginWord, 1));
//        visited.add(beginWord);
//        while(!q.isEmpty()) {
//            Pair<String, Integer> pair = q.remove();
//            String word = pair.getKey();
//            int level = pair.getValue();
//            for (int i = 0; i < len; i++) {
//                String replace = word.substring(0, i) + "*" + word.substring(i + 1, len);
//                for (String neigh : map.getOrDefault(replace, new ArrayList<>())) {
//                    if (neigh.equals(endWord)) {
//                        return level + 1;
//                    }
//                    if (!visited.contains(neigh)) {
//                        visited.add(neigh);
//                        q.add(new Pair(neigh, level + 1));
//                    }
//                }
//            }
//        }
//        return 0;
//    }
}
