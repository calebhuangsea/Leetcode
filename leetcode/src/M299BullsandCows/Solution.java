package M299BullsandCows;

public class Solution {
    /**
     * Time O(N)
     * Space O(1)
     */
    public String getHint(String secret, String guess) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int n = secret.length();
        int A = 0;
        int B = 0;
        for (int i = 0; i < n; i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                A++;
                continue;
            }
            arr1[c1 - '0']++;
            arr2[c2 - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(arr1[i], arr2[i]);
        }
        return A + "A" + B + "B";
    }
}
