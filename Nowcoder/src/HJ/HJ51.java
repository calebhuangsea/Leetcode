package HJ;


import java.util.Scanner;

public class HJ51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            //生成链表
            for (int i = 0; i < n; i++) {
                ListNode node = new ListNode(sc.nextInt());
                temp.next = node;
                temp = temp.next;
            }
            int k = Integer.parseInt(sc.next());
            if(getKthFromEnd(head.next,k) != null){
                System.out.println(getKthFromEnd(head.next,k).val);
            }
            else{
                System.out.println(0);
            }

        }
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode node = null;
        //记录有多少节点
        for (node = head; node != null; node = node.next) {
            n++;
        }
        //找倒数第k个
        for (node = head; n > k; n--) {
            node = node.next;
        }

        return node;
    }
}

class ListNode {
    ListNode next;
    int val;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

