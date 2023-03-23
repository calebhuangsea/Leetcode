package E706DesignHashMap;

class MyHashMap {
    /**
     * Use LinkedList and array combine, to avoid possible collisions and use hash functions
     * Time Complexity O(N) but mostly O(1) 19ms 80.73%
     * Space Complexity O(N) 46.6MB 93.67%
     */
    class Node {
        int key;
        int val;
        Node next;
        public Node(int k, int v, Node n) {
            key = k;
            val = v;
            next = n;
        }
    }

    private Node[] map;
    private final int size = 9999;
    private final int factor = 123763;

    private int hash(int k) {
        return (int)((long)k * factor % size);
    }

    public MyHashMap() {
        map = new Node[size];
    }

    public void put(int key, int value) {
        remove(key);
        int hashed = hash(key);
        map[hashed] = new Node(key, value, map[hashed]);
    }

    public int get(int key) {
        int hashed = hash(key);
        if (map[hashed] == null) {
            return -1;
        }
        Node node = map[hashed];
        while (node != null) {
            if (key == node.key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashed = hash(key);
        if (map[hashed] == null) {
            return;
        }
        Node node = map[hashed];
        if (node.key == key) {
            map[hashed] = node.next;
        } else {
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }


    /**
     * Naive List implementation
     * Time Complexity: O(N) for every operation 577ms 5.95%
     * Space Complexity: O(N) 47.2MB 89.6%
     */
//    class Pair {
//        int key;
//        int val;
//        public Pair(int k, int v) {
//            key = k;
//            val = v;
//        }
//    }
//    private List<Pair> map;
//
//    public MyHashMap() {
//        map = new ArrayList<>();
//    }
//
//    public void put(int key, int value) {
//        for (int i = 0; i < map.size(); i++) {
//            if (map.get(i).key == key) {
//                map.get(i).val = value;
//                return;
//            }
//        }
//        map.add(new Pair(key, value));
//    }
//
//    public int get(int key) {
//        for (int i = 0; i < map.size(); i++) {
//            if (map.get(i).key == key) {
//                return map.get(i).val;
//            }
//        }
//        return -1;
//    }
//
//    public void remove(int key) {
//        for (int i = 0; i < map.size(); i++) {
//            if (map.get(i).key == key) {
//                map.remove(i);
//                return;
//            }
//        }
//    }
}