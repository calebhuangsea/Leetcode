package Tesla;

public class T2_delete_identical {
    public static void main(String[] args) {
        T2_delete_identical t2DeleteIdentical = new T2_delete_identical();
        System.out.println(t2DeleteIdentical.solution("abccbd", new int[]{0,1,2,3,4,5}));
        System.out.println(t2DeleteIdentical.solution("aabbcc", new int[]{1,2,1,2,1,2}));
        System.out.println(t2DeleteIdentical.solution("aaaa", new int[]{3,4,5,6}));
        System.out.println(t2DeleteIdentical.solution("ababa", new int[]{10,5,10,5,10}));
    }
    public int solution(String s, int[] costs) {
        char[] cc = s.toCharArray();
        int cost = 0;

        int sum = costs[0];
        int max = costs[0];
        for (int i = 1; i < cc.length; i++) {
            char c = cc[i];
            if (c != cc[i - 1]) {
                cost += sum - max;
                max = costs[i];
                sum = costs[i];

            } else {
                max = Math.max(costs[i], max);
                sum += costs[i];
            }
        }
        cost += sum - max;
        return cost;
    }
}
