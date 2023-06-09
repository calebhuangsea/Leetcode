package Tesla;

public class T1_3A_3B {
    public static void main(String[] args) {
        T1_3A_3B t13A3B = new T1_3A_3B();
        System.out.println(t13A3B.solution("baaaaa"));
        System.out.println(t13A3B.solution("baaabbaabbba"));
        System.out.println(t13A3B.solution("baabab"));
    }
    public int solution(String string) {
        int count = 0;
        int len = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(i - 1)) {
                len = 1;
            } else {
                len++;
            }
            if (len == 3) {
                count++;
                len = 0;
            }
        }
        return count;
    }
}
