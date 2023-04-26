package E258AddDigits;

public class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num/=10;
        }

        return sum >= 10 ? addDigits(sum) : sum;
    }
}
