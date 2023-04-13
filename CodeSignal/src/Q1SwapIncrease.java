public class Q1SwapIncrease {
    public boolean solution(int[] nums) {
        int count = 1;
        if (nums.length > 1) {
            if (nums[0] >= nums[1]) {
                int min = help(nums[0], -1, nums[1]);
                if (min == -1) {
                    return false;
                }
                nums[0] = min;
                count--;
            }
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                continue;
            } else {
                if (count == 0) {
                    return false;
                } else {
                    int min = help(nums[i], nums[i - 1], nums[i + 1]);
                    if (min == -1) {
                        return false;
                    }
                    nums[i] = min;
                    count--;
                }
            }
        }
        return true;
    }

    private int help(int n, int prev, int next) {
        String num = Integer.toString(n);
        for (int i = 0; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                String s = swap(num, i, j);
                if (s.charAt(0) == '0') {
                    s = s.substring(1);
                }
                int nn = Integer.parseInt(s);
                if (nn > prev && nn < next) {
                    return nn;
                }
            }
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        if (j == str.length() - 1) {
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);
        }
        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1, str.length());
    }
}
