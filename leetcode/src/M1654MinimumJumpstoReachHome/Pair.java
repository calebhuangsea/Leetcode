package M1654MinimumJumpstoReachHome;

import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V val;
    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (!pair.getKey().equals(((Pair<?, ?>) o).getKey())) {
            return false;
        }
        if (!pair.getValue().equals(((Pair<?, ?>) o).getValue())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, val);
    }
}
