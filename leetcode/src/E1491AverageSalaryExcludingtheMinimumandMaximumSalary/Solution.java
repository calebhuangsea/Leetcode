package E1491AverageSalaryExcludingtheMinimumandMaximumSalary;

import java.util.Arrays;

public class Solution {
    /**
     * Time: O(NlogN)
     * Space: O(1)
     */
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / (salary.length - 2);
    }
}
