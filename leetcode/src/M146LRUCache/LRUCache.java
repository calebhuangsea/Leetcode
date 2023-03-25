package M146LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(1) 63ms 69.12%
 * Space Complexity: O(N) 111.8MB 67.6%
 */
public class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node (int k, int v) {
            key = k;
            val = v;
        }
    }

    // head as least used
    // tail as most frequent
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // if key exist, we update recently used
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {// if key doesn't exist
            if (map.size() == capacity) {
                // running out of space, remove LRU node
                map.remove(head.next.key);
                remove(head.next);
            }
            // add node
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        } else {
            // key exist
            // change priority and value
            Node node = map.get(key);
            remove(node);
            node.val = value;
            add(node);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}