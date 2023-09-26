package M1146SnapshotArray;

/**
 * Time: O(1), O(1), O(snap_id)
 * Space: O(N * MAX(snap_id))
 */
public class SnapshotArray {
    private Node[] arr;
    private Node[] append;
    private int nxt_id = 0;

    public SnapshotArray(int length) {
        arr = new Node[length];
        append = new Node[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Node(-1, 0);
            append[i] = arr[i];
        }
    }

    public void set(int index, int val) {
        if (append[index].sid == nxt_id) {
            append[index].val = val;
        } else {
            Node nxt = new Node(nxt_id, val);
            append[index].next = nxt;
            append[index] = nxt;
        }
    }

    public int snap() {
        return nxt_id++;

    }

    public int get(int index, int snap_id) {
        Node node = arr[index];
        while (node.next != null && node.next.sid <= snap_id) {
            node = node.next;
        }
        return node.val;
    }
    /**
     * Time: O(nlog(n))
     * Space: O(n)
     */
//    int snapId = 0;
//    TreeMap<Integer, Integer>[] historyRecords;
//
//    public SnapshotArray(int length) {
//        historyRecords = new TreeMap[length];
//        for (int i = 0; i < length; i++) {
//            historyRecords[i] = new TreeMap<Integer, Integer>();
//            historyRecords[i].put(0, 0);
//        }
//    }
//
//    public void set(int index, int val) {
//        historyRecords[index].put(snapId, val);
//    }
//
//    public int snap() {
//        return snapId++;
//    }
//
//    public int get(int index, int snapId) {
//        return historyRecords[index].floorEntry(snapId).getValue();
//    }
}

class Node {
    Node next;
    int sid;
    int val;
    public Node (int id, int val) {
        next = null;
        this.sid = id;
        this.val = val;
    }
}
