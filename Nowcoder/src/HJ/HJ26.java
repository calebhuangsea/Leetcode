package HJ;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        char[] arr = s.toCharArray();
        char[] lower = s.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (lower[i] < 'a' || lower[i] > 'z') {
                continue; // not an english character
            }
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (lower[j] < 'a' || lower[j] > 'z') {
                    continue; // not an english character
                }
                if (lower[j] < lower[index]) {
                    index = j;
                }
            }
            if (index == i)continue;
            swap(arr, i, index);
            swap(lower, i, index);
            for (int j = index - 1; j > i; j--) {
                if (lower[j] == lower[index]) {
                    swap(lower, j, index);
                    swap(arr, j, index);
                    index = j;
                }
            }
        }
        System.out.println(new String(arr));
    }

    private static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
