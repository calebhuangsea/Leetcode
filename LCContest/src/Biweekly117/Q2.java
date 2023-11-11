package Biweekly117;

public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.distributeCandies(1, 3));
//        System.out.println(q2.distributeCandies(10, 3));
//        System.out.println(q2.distributeCandies(1000000000, 1));
//        System.out.println(q2.distributeCandies(1000000000, 1000000000));
    }

    public long distributeCandies(int n, int limit) {
        if (limit * 3 < n) {
            return 0;
        }
        // how many combination of 3 numbers that sum up to n but none of them exceed limit
        long res = 0;
        for (int i = Math.min(limit, n); i >= 0; i--) {
            // pick for the first num
            int n2 = n - i;
            if (n2 > limit * 2) continue;
            // how many combination of 2 numbers that sum up to n2 but none of them exceed limit
            int j = Math.min(limit, n2); // max we can pick from the second one
            // we need to do a binary search here
            int k = Math.max(0, n2 - j);
            res += j - k + 1;
        }
        return res;
    }
//    public long distributeCandies(int n, int limit) {
//
//        return helper(3, n, limit);
//    }
//
//    private long helper(int k, int n, int limit) {
//        if (k == 0) return n == 0 ? 1 : 0;
//        // k people
//        if (k * limit < n) {
//            return 0;
//        }
//        long count = 0;
//        for (int i = 0; i <= limit; i++) {
//            count += helper(k - 1, n - i, limit);
//        }
//        return count;
//    }
}
