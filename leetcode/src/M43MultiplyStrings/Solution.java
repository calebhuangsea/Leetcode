package M43MultiplyStrings;

public class Solution {
    /**
     * Time Complexity O(N * M) 4ms 90.35%
     * Space Complexity O(N + M) 43MB 14.95%
     */
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        int a;
        int b;
        for (int i = num1.length() - 1; i >= 0; i--) {
            a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                b = num2.charAt(j) - '0';
                int idx = i + j + 1;
                int product = a * b + res[idx];
                res[idx] = product % 10;
                res[idx - 1] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = res[0] == 0 ? 1 : 0;
        for (int i = start; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
