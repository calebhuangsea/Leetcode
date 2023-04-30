package SnowFlake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://www.1point3acres.com/bbs/thread-985400-1-1.html
 * dfs+memo
 * 记得用long然后转为int
 *
 * 刷表dp写崩了，记忆化搜了搜剪枝T了最后2个点。
 * 原来Hackerrank是可以开[1000][10000]的。。。。
 * 但是vector不可以，所以要memset
 *
 * https://leetcode.com/discuss/int ... 204;uestion/2775415
 */
public class TaskScheduling {
    private static final long INF = Long.MAX_VALUE / 5;
    private static long getMinCost(int[] cost, int[] time) {
        Map<Integer,Long>[] memo = new Map[cost.length];
        for (int i = 0; i < cost.length; i++) memo[i] = new HashMap<>();
        return dfs(0, cost, 0, time, memo);
    }

    private static long dfs(int i, int[] cost, int timeSoFar, int[] time, Map<Integer,Long>[] memo) {
        int n = cost.length;
        if (i == n) return timeSoFar >= 0 ? 0 : INF;
        if (timeSoFar >= n - i) return 0;
        if (memo[i].containsKey(timeSoFar)) return memo[i].get(timeSoFar);
        long resPaid = cost[i] + dfs(i+1, cost, timeSoFar + time[i], time, memo); // paid server
        long resFree = dfs(i+1, cost, timeSoFar - 1, time, memo); // free server
        memo[i].put(timeSoFar, Math.min(resPaid, resFree));
        return memo[i].get(timeSoFar);
    }

    public static void main(String[] args) {
        System.out.println("Expected: 1, actual: " + getMinCost(new int[] {1,1,3,4}, new int[] {3,1,2,3}));
        System.out.println("Expected: 3, actual: " + getMinCost(new int[] {1,2,3,2}, new int[] {1,2,3,2}));
        System.out.println("Expected: 4, actual: " + getMinCost(new int[] {2,3,4,2}, new int[] {1,1,1,1}));
        System.out.println("Expected: 4, actual: " + getMinCost(new int[] {2,3,4,5}, new int[] {1,1,5,3}));
        System.out.println("Expected: 10, actual: " + getMinCost(new int[] {5,6,7,8,8,10}, new int[] {1,1,1,1,1,10}));
        System.out.println("Expected: 20, actual: " + getMinCost(new int[] {10,10,10,10,10,20,20,20}, new int[] {3,3,3,3,3,6,6,6}));
        System.out.println("Expected: 18, actual: " + getMinCost(new int[] {5,6,7,8,1000000}, new int[] {1,1,1,1,1000}));
        // 1000 size example
        List<Integer> costList = List.of(6,3,9,5,1000000,2,3,4,4,5);
        List<Integer> timeList = List.of(3,1,2,3,1000,1,1,1,1,7);
        List<Integer> largeCostList = new ArrayList<>();
        List<Integer> largeTimeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            largeCostList.addAll(costList);
            largeTimeList.addAll(timeList);
        }
        int[] cost = largeCostList.stream().mapToInt(Integer::intValue).toArray();
        int[] time = largeTimeList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Expected: 700, actual: " + getMinCost(cost, time));
        // 1000 size example 2
        int[] cost2 = IntStream.iterate(1000000, i->1000000).limit(1000).toArray();
        int[] time2 = IntStream.iterate(1000, i->1000).limit(1000).toArray();
        System.out.println("Expected: 1000000, actual: " + getMinCost(cost2, time2));
    }
}
