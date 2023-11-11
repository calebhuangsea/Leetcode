package M2849DeterminifaCellIsReachableataGivenTime;

public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) return t != 1;
        int dx = Math.abs(sx - fx);
        int dy = Math.abs(sy - fy);
        int min = Math.min(dx, dy);
        int sum = dx + dy -  min;
        return sum <= t;
    }
}
