package Weekly344;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}};
        System.out.println(Arrays.toString(colorTheArray(4, arr)));
    }
    public static int[] colorTheArray(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int[] arr = new int[n];
        arr[queries[0][0]] = queries[0][1];
        for (int i = 1; i < queries.length; i++) {
            int[] q = queries[i];
            int index = q[0];
            int color = q[1];
            // if we are breaking in the middle, that will lose 2 counts
            // if we are breaking from left or right, it will only lose 1 counts, so we only need to check left and right
            int oldColor = arr[index];
            if (oldColor == color) {
                res[i] = res[i - 1];
                continue;
            }
            int count = res[i - 1];
            // check if index is at the right side
            if (oldColor != 0 && index > 0 && oldColor == arr[index - 1]) {
                count--;
            }
            if (oldColor != 0 && index < n - 1 && oldColor == arr[index + 1]) {
                count--;
            }
            // check the situation where we are appending
            if (index > 0 && color == arr[index - 1]) {
                count++;
            }
            if (index < n - 1 && color == arr[index + 1]) {
                count++;
            }
            res[i] = count;
            arr[index] = color;
        }

        return res;
    }
}
