package Weekly338;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(primeSubOperation(new int[] {5, 16, 14, 9}));
    }
    public static boolean primeSubOperation(int[] nums) {
        for (int i = nums[0] - 1; i >= 2; i--) {
            if (isPrime(i)) {
                nums[0] -= i;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i] - 1 - nums[i - 1]; j >= 1; j--) {
                if (isPrime(j)) {
                    nums[i] -= j;
                    break;
                }
            }
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int n)
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

}
