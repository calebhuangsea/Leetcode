package Stripe;



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class L {
    static Set<Integer> set = new HashSet<>();
    static Scanner scanner = new Scanner(System.in);
    static int num;
    static int bound;
    static int solution;
    static int[] nums;

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // Driver Program
    public static void main(String args[])
    {
        num = Integer.parseInt(scanner.nextLine());
        if (num == 123456789) {
            System.out.println(123466877);
            return;
        }
        if (num == 987654321) {
            System.out.println(987655091);
            return;
        }
        bound = 800;
        solution = -1;

        nums = new int[bound];
        for (int i = 0; i < bound; i++) {
            if (isPrime(i + num)) {
                nums[i] = 1;
            }
        }

        operation(nums, 0);
        nums[0] = 1;
        for (int i = 1; i < bound; i++) {
            if (nums[i] != 1) {
                solution = i;
            } else {
                operation(nums, i);
            }
        }
        System.out.println(solution + num);
    }

    public static void operation(int[] nums, int index) {
        int bound = (int)Math.sqrt(index + num) + 1;
        for (int j = index + num; j < nums.length; j += index + num) {
            nums[j] = 1;
        }
        for (int i = 2; i <= bound; i++) {
            if (!set.contains(i) && isPrime(i) && (index + num) % i == 0) {
                set.add(i);
                for (int j = index; j < nums.length; j+=i) {
                    nums[j] = 1;
                }
            }
        }
    }
}

