package Weekly343;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,2,6,3};
        int[][] a2 = new int[][] {
                {4,3,5}, {1,2,6}
        };
        System.out.println(firstCompleteIndex(arr, a2));
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                map.put(mat[x][y], new int[] {x, y});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] a = map.get(arr[i]);
            rows[a[0]]++;
            cols[a[1]]++;
            if (rows[a[0]] == mat[0].length || cols[a[1]] == mat.length) {
                return i;
            }
        }
        return -1;
    }
}
