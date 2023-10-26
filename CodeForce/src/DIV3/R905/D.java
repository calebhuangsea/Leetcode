package DIV3.R905;


import java.util.*;

public class D {
    static class Pair {
        int l;
        int r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return this.l == pair.l && this.r == pair.r;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        // record the left most and right most pair
        Deque<Pair> left = new LinkedList<>();
        Deque<Pair> right = new LinkedList<>();
        for (int t = 0; t < times; t++) {
            String op = sc.next();
            int l = sc.nextInt();
            int r = sc.nextInt();
            Pair pair = new Pair(l, r);
            if (op.equals("+")) {
                if (left.isEmpty()) {
                    left.offerLast(pair);
                } else if (right.isEmpty()) {
                    right.offerLast(pair);
                } else if (left.peekFirst().r > r) {
                    left.offerFirst(pair);
                } else if (right.peekFirst().l < l) {
                    right.offerFirst(pair);
                } else {
                    while (!left.isEmpty() && left.peekLast().r >= r) {
                        right.offerLast(left.pollLast());
                    }
                    left.offerLast(pair);
                }
            } else {
                if (left.contains(pair)) {
                    left.remove(pair);
                } else {
                    right.remove(pair);
                }
                if (left.isEmpty() && !right.isEmpty()) {
                    left.offerLast(right.pollLast());
                } else if (right.isEmpty() && !left.isEmpty()) {
                    right.offerLast(left.pollFirst());
                }
            }
            if (left.isEmpty() || right.isEmpty()) {
                System.out.println("NO");
            } else {
                Pair leftMost = left.peek();
                Pair rightMost = right.peek();
                if (leftMost.r >= rightMost.l) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}

