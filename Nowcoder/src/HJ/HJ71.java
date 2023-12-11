package HJ;

import java.util.*;

public class HJ71 {
    // 参考 leetcode 44 题
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = s.charAt(i - 1);
                // 注意：*和?处理的是字母和数字，所以要加判断
                if (p.charAt(j - 1) == '*' && (Character.isLetter(ch) ||
                        Character.isDigit(ch))) {
                    // ************ 千万要注意，这里一定要加上 dp[i - 1][j - 1]，因为?的功能*同样拥有
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '?' && (Character.isLetter(ch) ||
                        Character.isDigit(ch))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String pattern = in.nextLine();
            String str = in.nextLine();

            // 处理大写字符，防止比较的时候由于大写问题导致计算错误
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isLetter(ch) && Character.isUpperCase(ch)) {
                    newS.append(Character.toLowerCase(ch));
                } else {
                    newS.append(ch);
                }
            }
            StringBuilder newP = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                char ch = pattern.charAt(i);
                if (Character.isLetter(ch) && Character.isUpperCase(ch)) {
                    newP.append(Character.toLowerCase(ch));
                } else {
                    newP.append(ch);
                }
            }

            boolean ans = isMatch(newS.toString(), newP.toString());
            System.out.println(ans);
        }
    }
}
