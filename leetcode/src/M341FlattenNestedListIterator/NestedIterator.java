//package M341FlattenNestedListIterator;
//
///**
// * // This is the interface that allows for creating nested lists.
// * // You should not implement it, or speculate about its implementation
// * public interface NestedInteger {
// *
// *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
// *     public boolean isInteger();
// *
// *     // @return the single integer that this NestedInteger holds, if it holds a single integer
// *     // Return null if this NestedInteger holds a nested list
// *     public Integer getInteger();
// *
// *     // @return the nested list that this NestedInteger holds, if it holds a nested list
// *     // Return empty list if this NestedInteger holds a single integer
// *     public List<NestedInteger> getList();
// * }
// */
//import java.util.NoSuchElementException;
//public class NestedIterator implements Iterator<Integer> {
//    private Deque<NestedInteger> deq;
//    public NestedIterator(List<NestedInteger> nestedList) {
//        deq = new ArrayDeque(nestedList);
//    }
//
//    @Override
//    public Integer next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        return deq.removeFirst().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        make();
//
//        return !deq.isEmpty();
//    }
//
//    private void make() {
//        while (!deq.isEmpty() && !deq.peekFirst().isInteger()) {
//            List<NestedInteger> ls = deq.removeFirst().getList();
//            for (int i = ls.size() -1; i >= 0; i--) {
//                deq.addFirst(ls.get(i));
//            }
//        }
//    }
//}
//
///**
// * Your NestedIterator object will be instantiated and called as such:
// * NestedIterator i = new NestedIterator(nestedList);
// * while (i.hasNext()) v[f()] = i.next();
// */
