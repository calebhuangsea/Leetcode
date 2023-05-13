package Biweekly104;

import java.util.*;

public class A {
    public static void main(String[] args) {
        A a = new A();

    }

    public int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) {
            String sub = s.substring(11, 13);
            int i = Integer.parseInt(sub);
            if (i > 60) {
                count++;
            }
        }
        return count;
    }
}
