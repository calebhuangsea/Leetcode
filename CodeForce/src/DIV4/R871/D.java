package DIV4.R871;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int z = 0; z < lines; z++) {
            int start = sc.nextInt();
            int target = sc.nextInt();
            if (start < target) {
                System.out.println("NO");
                continue;
            }
            if (dfs(start, target)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static boolean dfs(int start, int target) {
        if (start == target) {
            return true;
        }
        if (start % 3 != 0) {
            return false;
        }
        return dfs(start / 3 * 2, target) || dfs(start / 3, target);
    }
}
