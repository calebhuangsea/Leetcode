package M284PeekingIterator;

import java.util.Iterator;

public // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Integer pop;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        pop = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (pop != null) {
            return pop;
        }
        pop = iterator.next();
        return pop;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (pop != null) {
            int temp = pop;
            pop = null;
            return temp;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return pop != null || iterator.hasNext();
    }
}
