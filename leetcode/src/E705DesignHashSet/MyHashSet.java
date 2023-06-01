package E705DesignHashSet;

/**
 * Time: O(1)
 * Space: O(n)
 */
public class MyHashSet {
    private boolean[] ht;

    public MyHashSet() {
        ht = new boolean[1000001];
    }

    public void add(int key) {
        ht[key] = true;
    }

    public void remove(int key) {
        ht[key] = false;
    }

    public boolean contains(int key) {
        return ht[key];
    }
}
