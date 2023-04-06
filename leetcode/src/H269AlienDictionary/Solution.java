package H269AlienDictionary;

import java.util.*;

public class Solution {
    /**
     * Time Complexity O(C) length of all word
     * Space Complexity O(C)
     */
    public String alienOrder(String[] words) {
        // relationship between characters
        Map<Character, List<Character>> adjList = new HashMap<>();
        // incoming degree for each character
        Map<Character, Integer> counts = new HashMap<>();

        // initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Build relationship and edges
        // compare every two words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                // conflict because i should has a higher rank
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    adjList.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    counts.put(words[i + 1].charAt(j), counts.get(words[i + 1].charAt(j)) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character neigh : adjList.get(c)) {
                counts.put(neigh, counts.get(neigh) - 1);
                if (counts.get(neigh).equals(0)) {
                    queue.add(neigh);
                }
            }
        }
        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
