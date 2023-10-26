package DIV3.R905;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int t = 0; t < times; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String line = sc.next();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : line.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int toPick = n - k;
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();
            Collections.sort(odd, Collections.reverseOrder());
            for (int v : map.values()) {
                if (v % 2 == 1) {
                    odd.add(v);
                } else {
                    even.add(v);
                }
            }
            // even is always safe to pick!
            for (int v : even) {
                if (toPick <= 0) {
                    break;
                }
                toPick -= v;
            }
            // no single is picked
            boolean flag = false;
            for (int v : odd) {
                if (toPick <= 0) {
                    break;
                }
                if (flag) {
                    if (v < 2) continue;
                    toPick -= v - 1;
                    continue;
                }
                // need extra handle in odd, what if we want to take an even here?
                toPick -= v;
                flag = true; // this means we have taken an odd
            }
            if (toPick <= 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
