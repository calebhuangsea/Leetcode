package DIV2.R904;


import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int t = 0; t < times; t++) {
            int n = sc.nextInt();
            String line = sc.next();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (line.charAt(i) == '0') stack.add(i);
            }
            long step = 0;
            int i;
            StringBuilder sb = new StringBuilder();
            for (i = n - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    break;
                }
                int v = stack.pop();
                step += Math.abs(v - i);
                sb.append(step + " ");
            }
            while (i >= 0) {
                sb.append(-1 + " ");
                i--;
            }
            System.out.println(sb);
        }
    }

}

