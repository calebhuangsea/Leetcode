package M1472DesignBrowserHistory;

import java.util.*;

class BrowserHistory {

    /**
     * Solution 1: Use two stacks for forward and backward
     * Time Complexity: Visit(O(1)), Back(O(N)), Forward(O(N)) 106ms 24.3%
     * Space Complexity: O(N), we use two stack, their size combing would only be N urls
     */
//    private Stack<String> history;
//    private Stack<String> future;
//    public BrowserHistory(String homepage) {
//        history = new Stack<>();
//        future = new Stack<>();
//        history.push(homepage);
//    }
//
//    public void visit(String url) {
//        history.push(url);
//        future.clear();
//    }
//
//    public String back(int steps) {
//        int size = history.size() - 1 >= steps ? steps : history.size() - 1;
//        for (int i = 0; i < size; i++) {
//            future.push(history.pop());
//        }
//        return history.peek();
//    }
//
//    public String forward(int steps) {
//        int size = future.size() >= steps ? steps : future.size();
//        for (int i = 0; i < size; i++) {
//            history.push(future.pop());
//        }
//        return history.peek();
//    }

    /**
     * Solution 2: Use a single array list and an index to store urls
     * Time Complexity: Visit(O(1)), Back(O(N)), Forward(O(N)) 58ms 60.3%
     * Space Complexity: O(N), only use a list, maximum store n urls
      */
    private List<String> urls;
    private int index;

    public BrowserHistory(String homepage) {
        index = 0;
        urls.add(homepage);
    }

    public void visit(String url) {
        while (urls.size() > index + 1) {
            urls.remove(urls.size() - 1);
        }
        urls.add(url);
        index++;
    }

    public String back(int steps) {
        int size = index >= steps ? steps : index;
        index -= size;
        return urls.get(index);
    }

    public String forward(int steps) {
        int size = urls.size() - 1 - index >= steps ? steps : urls.size() - 1 - index;
        index += size;
        return urls.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
