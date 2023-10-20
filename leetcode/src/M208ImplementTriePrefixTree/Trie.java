package M208ImplementTriePrefixTree;

import java.util.HashMap;
import java.util.Map;

class Trie {
    Node root;

    public Trie() {
        root = new Node('0', new HashMap<>(), false);
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.neighbors.containsKey(c)) {
                // just update
                node = node.neighbors.get(c);
            } else {
                // create a new Node
                Node nei = new Node(c, new HashMap<>(), false);
                node.neighbors.put(c, nei);
                node = nei;
            }
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.neighbors.containsKey(c)) {
                // just update
                node = node.neighbors.get(c);
            } else {
                return false;
            }
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.neighbors.containsKey(c)) {
                // just update
                node = node.neighbors.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

class Node {
    char val;
    boolean isWord;
    Map<Character, Node> neighbors;

    public Node(char val, Map<Character, Node> neighbors, boolean isWord) {
        this.val = val;
        this.isWord = isWord;
        this.neighbors = neighbors;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
