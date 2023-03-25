package M155MinStack;

import java.util.Stack;

/**
 * Use a min stack and normal stack
 * Time Complexity: O(1) 5ms 70.69%
 * Space Complexity: O(N) 44.8MB 16.36%
 */
class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> stack;

    public MinStack() {
        min = new Stack();
        stack = new Stack();
    }

    public void push(int val) {
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
