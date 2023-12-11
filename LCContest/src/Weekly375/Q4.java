package Weekly375;
import java.util.*;
public class Q4 {

    public int numberOfGoodPartitions(int[] a) {
        int n = a.length;
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for(int i = 0;i < n;i++){
            if(!first.containsKey(a[i])){
                first.put(a[i], i);
            }
            last.put(a[i], i);
        }
        int[] imos = new int[n+1];
        for(int k : first.keySet()){
            int f = first.get(k);
            int l = last.get(k);
            imos[f]++;
            imos[l]--;
        }
        for(int i = 0;i < n;i++){
            imos[i+1] += imos[i];
        }

        final int mod = 1000000007;
        long ans = 1;
        for(int i = 0;i < n-1;i++){
            if(imos[i] == 0){
                ans *= 2;
            }
            ans %= mod;
        }
        return (int)ans;
    }
}
