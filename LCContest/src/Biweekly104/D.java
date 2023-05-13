package Biweekly104;
import java.util.*;
public class D {
    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.sumOfPower(new int[] {2,1,4}));
        System.out.println(d.sumOfPower(new int[] {1,2, 3}));
    }
    public int sumOfPower(int[] nums) {
        long max = 0;
        long mod = (long) 1e9 + 7;
        long s = 0;
        Arrays.sort(nums);
        for (long x : nums) {
            max = (max + x * x % mod * (x + s)) % mod;
            s = (s * 2 + x) % mod;
        }
        return (int)(max % mod);
    }
}
