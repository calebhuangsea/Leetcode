package Weekly371;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        // [1,10,10,3,10,4,10,4,10,5,5,10,5,10,10,10,6,6,10,10,10,8,10,9,10,10,10,10]
        //[10,2,3,10,4,10,4,10,5,10,10,5,10,6,6,6,10,10,6,6,7,10,8,10,10,10,10,10]
        int[] n1 = {1,2,7};
        int[] n2 = {4,5,3};
        System.out.println(q3.minOperations(n1, n2));
    }
    public int minOperations(int[] nums1, int[] nums2) {
        // how do know if this is impossible?
        // greedy?
        int c1 = 0, c2 = 1;
        int n = nums1.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums1[i] <= nums1[n - 1] && nums2[i] <= nums2[n - 1]) { // no need to swap

            } else if (nums1[i] <= nums2[n - 1] && nums2[i] <= nums1[n - 1]){
                c1++;
            } else {
                c1 = Integer.MIN_VALUE;
            }

            if (nums1[i] <= nums2[n - 1] && nums2[i] <= nums1[n - 1]) { // no need to swap
                continue;
            } else if (nums1[i] <= nums1[n - 1] && nums2[i] <= nums2[n - 1]){
                c2++;
            } else {
                c2 = Integer.MIN_VALUE;
            }
            // try to swap and check if it is still valid
        }
        if (c1 < 0 && c2 < 0) {
            return -1;
        } else if (c1 >= 0 && c2 >= 0){
            return Math.min(c1, c2);
        }
        return Math.max(c1, c2);
    }

    private int solve(int[] n1, int[] n2, int i) {
        if (i < 0) return 0;
        int none = Integer.MAX_VALUE / 3;
        if (n1[i] <= n1[n1.length - 1] && n2[i] <= n2[n2.length - 1]) {
            none = solve(n1, n2, i - 1);
        }
        int swap = Integer.MAX_VALUE / 3;
        // swap
        swap(n1, n2, i);
        if (n1[i] <= n1[n1.length - 1] && n2[i] <= n2[n2.length - 1]) {
            swap = 1 + solve(n1, n2, i - 1);
        }
        swap(n1, n2, i);

        return Math.min(none, swap);
    }

    private void swap(int[] n1, int[] n2, int i) {
        int tmp = n1[i];
        n1[i] = n2[i];
        n2[i] = tmp;
    }
}
