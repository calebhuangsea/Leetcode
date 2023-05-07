package Weekly344;
import java.util.*;
public class Q4 {
    /**
     * Find the largest path using dfs
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minIncrements(3, new int[] {5,3,3}));
        System.out.println(minIncrements(7, new int[] {1,5,2,2,3,3,1}));
        System.out.println(minIncrements(15, new int[] {764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761}));
    }

    static int max = 0;
    static int count = 0;

    public static int minIncrements(int n, int[] cost) {
        // BFS on every level
        if (n == 1) {
            return 0;
        }
        findMax(1, n, 0, cost);
        dfs(1, n, 0, cost);
        return  count;
    }
    private static void findMax(int i, int n, int sum, int cost[]) {
        sum += cost[i - 1];
        if (i * 2 >= n) {
            // no more
            max = Math.max(max, sum);
            return;
        }
        findMax(i * 2, n, sum, cost);
        findMax(i * 2 + 1, n, sum, cost);
    }
    private static int dfs(int i, int n, int sum, int cost[]) {
        sum += cost[i - 1];
        if (i * 2 >= n) {
            return sum;
        }
        int left = dfs(i * 2, n, sum, cost);
        int right = dfs(i * 2 + 1, n, sum, cost);
        if (left == max || right == max) {
            count += Math.abs(left - max);
            count += Math.abs(right - max);
            return max;
        } else {
            int sub = Math.max(left, right);
            count += Math.abs(left - right);
            return sub;
        }
    }
}
