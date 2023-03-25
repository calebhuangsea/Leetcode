import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        int[] arr = new int[2];
        set.add(arr);
        arr[1] = 1;
        set.remove(arr);
        System.out.println(set);
    }
}
