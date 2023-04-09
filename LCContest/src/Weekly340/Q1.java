package Weekly340;
import java.util.*;

public class Q1 {
    /**
     * Time Complexity O(N)
     * Time Complexity O(N)
     */
    public int diagonalPrime(int[][] nums) {
        int largestPrime = 0; // variable to store the largest prime number
        int n = nums.length; // size of the square matrix

        // iterate through the diagonal elements of the matrix
        for (int i = 0; i < n; i++) {
            // check if the diagonal element is prime
            if (isPrime(nums[i][i])) {
                // update the largestPrime if the current diagonal element is larger
                largestPrime = Math.max(largestPrime, nums[i][i]);
            }

            // check if the anti-diagonal element is prime
            if (isPrime(nums[i][n - i - 1])) {
                // update the largestPrime if the current anti-diagonal element is larger
                largestPrime = Math.max(largestPrime, nums[i][n - i - 1]);
            }
        }

        return largestPrime;
    }

    private boolean isPrime(int n) {
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
