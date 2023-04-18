public class Q1SwapIncrease {
    public boolean solution(int[] nums) {
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (index == -1) {
                    index = i - 1;
                } else {
                    return false;
                }
            }
        }
        if (index == -1) {
            return true;
        }
        if (index == 0) {
            return help(nums[0], -1, nums[1]) != -1;
        } else {
            return help(nums[index], nums[index - 1], nums[index + 1]) != -1;
        }
    }

    private int help(int n, int prev, int next) {
        String num = Integer.toString(n);
        for (int i = 0; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                // Swap digits
                char[] numArr = num.toCharArray();
                char temp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = temp;
                // Convert back to integer
                int nn = Integer.parseInt(new String(numArr));
                // Check if swapped number is strictly greater than prev and strictly less than next
                if (nn > prev && nn < next) {
                    return nn;
                }
            }
        }
        return -1;
    }

}
