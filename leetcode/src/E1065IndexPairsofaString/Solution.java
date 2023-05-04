package E1065IndexPairsofaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Time: O(L^2 + ns)
     */
    class Node {
        public boolean flag;
        public Map<Character, Node> next = new HashMap<>();
    }

    class Trie {
        public Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.next.containsKey(c)) {
                    curr.next.put(c, new Node());
                }
                curr = curr.next.get(c);
            }
            curr.flag = true;
        }
    }

    public int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            Node node = trie.root;
            for (int j = i; j < text.length(); j++) {
                if (!node.next.containsKey(text.charAt(j))) {
                    break;
                }
                node = node.next.get(text.charAt(j));
                if (node.flag) {
                    res.add(new int[] {i, j});
                }
            }
        }
        return (int[][]) res.toArray();
    }
}
