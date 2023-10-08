package M1804ImplementTrieII_PrefixTree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node(new int[] {0, 0, 0}, new HashMap<>());
    }

    public void insert(String word) {
        char[] w = word.toCharArray();
        Node curr = root;
        for (char c : w) {
            if (!curr.next.containsKey(c)) {
                curr.next.put(c, new Node(new int[] {(int)c, 0, 0}, new HashMap()));
            }
            curr = curr.next.get(c);
            curr.val[1]++;
        }
        curr.val[2]++;
    }

    public int countWordsEqualTo(String word) {
        Node curr = root;
        char[] w = word.toCharArray();
        for(char c : w) {
            if (curr.next.containsKey(c)) {
                curr = curr.next.get(c);
            } else {
                return 0;
            }
        }
        return curr.val[2];
    }

    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        char[] w = prefix.toCharArray();
        for(char c : w) {
            if (curr.next.containsKey(c)) {
                curr = curr.next.get(c);
            } else {
                return 0;
            }
        }
        return curr.val[1];
    }

    public void erase(String word) {
        erase(word.toCharArray(), 0, root);
    }

    // abc
    // a
    private boolean erase(char[] w, int index, Node curr) {
        if (index == w.length) {
            curr.val[2]--;
            return true;
        }
        char c = w[index];
        if (curr.next.containsKey(c)) {
            Node nxt = curr.next.get(c);
            if (erase(w, index + 1, nxt)) {
                curr.next.get(c).val[1] -= 1;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

class Node {
    // [current character, prefix word, this word]
    int[] val;
    Map<Character, Node> next;

    public Node (int[] val, Map<Character, Node> next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
