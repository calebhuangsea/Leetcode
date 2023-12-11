package Huawei;

public class T1 {
    public static void main(String[] args) {
        System.out.println(solve("abc", "aabbbcc"));
        System.out.println(solve("abc", "aabbdc"));
        System.out.println(solve("abc", "aabbbccd"));
        System.out.println(solve("abc", "abc"));
    }
    public static boolean solve(String name, String word) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < word.length()) {
            char c1 = name.charAt(i);
            char c2 = word.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else if (j > 0 && c2 == word.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        while (j < word.length()) {
            if (j > 0 && word.charAt(j) != word.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return i == name.length();
    }
}
