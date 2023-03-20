import java.util.Arrays;

public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String[] args) {
        String s = "0#1L2R#3L#";
        System.out.println(Arrays.toString(s.split("#")));
    }
}
