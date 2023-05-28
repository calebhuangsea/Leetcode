package H952LargestComponentSizebyCommonFactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);

        Map<Integer, List<Integer>> factorsMap = new HashMap<>();

        // factor ：indices
        for (int i = 0; i < n; i++) {
            List<Integer> factors = getFactors(nums[i]);
            for (int factor : factors) {
                if (!factorsMap.containsKey(factor)) {
                    factorsMap.put(factor, new ArrayList<>());
                }
                factorsMap.get(factor).add(i);
            }
        }
        int max = 1;
        // Union every pair of indices that share a common factor
        for (List<Integer> indices : factorsMap.values()) {
            if (indices.size() > 1) {
                for (int i = 1; i < indices.size(); i++) {
                    max = Math.max(max, uf.union(indices.get(0), indices.get(i)));
                }
            }
        }
        return max;

    }

    private List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }
}

class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                return size[rootX];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                return size[rootY];
            }
        }
        return -1;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
