package HJ;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ67 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) arr[i] = in.nextInt();
        System.out.println(solve(arr, 0, new HashSet<>()));
    }

    private static boolean solve(int[] arr, double sum, Set<Integer> visited) {
        if (visited.size() == 4 && sum == 24) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (visited.contains(i)) continue;
            int n = arr[i];
            visited.add(i);
            flag |= solve(arr, sum + n, visited);
            if (visited.size() > 1) {
                flag |= solve(arr, sum - n, visited);
                flag |= solve(arr, sum * n, visited);
                flag |= solve(arr, sum / n, visited);
            }
            visited.remove(i);
        }
        return flag;
    }
}
