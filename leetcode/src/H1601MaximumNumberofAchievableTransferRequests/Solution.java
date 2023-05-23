package H1601MaximumNumberofAchievableTransferRequests;

public class Solution {
    /**
     * Time: O(M * 2^N)
     * Space: O(M + N)
     */
    int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        int[] move = new int[n];
        for (int[] req : requests) {
            arr[req[0]]++;
            move[req[0]]++;
        }
        dfs(0, arr, move, requests, 0);
        return max;
    }

    private void dfs(int count, int[] arr, int[] move, int[][] req, int index) {
        if (index == req.length) {
            boolean f = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != move[i]) {
                    f = false;
                    break;
                }
            }
            if (f) {
                max = Math.max(count, max);
            }
            return;
        }
        move[req[index][0]]--;
        move[req[index][1]]++;
        dfs(count+1,arr,move, req, index + 1);
        move[req[index][0]]++;
        move[req[index][1]]--;
        dfs(count, arr, move, req, index + 1);
    }
}
