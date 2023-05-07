package H1964FindtheLongestValidObstacleCourseatEachPosition;

public class Solution {
    /**
     * Time: O(nlogn)
     * Space: O(n)
     */
    public int[] longestObstacleCourseAtEachPosition(int[] obs) {
        int n = obs.length;
        int[] res = new int[n];
        int[] lis = new int[n];
        int ll = 0;
        for (int i = 0; i < n; i++) {
            int h = obs[i];
            int idx = bi(lis, h, ll);
            if (idx == ll) {
                ll++;
            }
            lis[idx] = h;
            res[i] = idx + 1;
        }
        return res;
    }

    private int bi(int[] arr, int target, int right) {
        if (right == 0) {
            return 0;
        }
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
