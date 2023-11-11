package Weekly370;
import java.util.*;
public class Q2 {
    public int findChampion(int n, int[][] edges) {
        int[] in = new int[n];
        for (int[] e : edges) {
            // 0 -> 1
            in[e[1]]++;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                if (res == -1) res = i;
                else return -1;
            }
        }
        return res;
    }



}


