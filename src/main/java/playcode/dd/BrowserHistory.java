package playcode.dd;

import java.util.*;

//1472. Design Browser History
public class BrowserHistory {
    private String current;
    private Deque<String> back;
    private Deque<String> forward;

    public BrowserHistory(String homepage) {
        current = homepage;
        back = new ArrayDeque<>();
        forward = new ArrayDeque<>();
    }

    public void visit(String url) {
        back.push(current);
        current = url;
        forward.clear();

    }

    public String back(int steps) {
        while (!back.isEmpty() && steps-- > 0) {
            forward.push(current);
            current = back.pop();
        }
        return current;
    }

    public String forward(int steps) {
        while (!forward.isEmpty() && steps-- > 0) {
            back.push(current);
            current = forward.pop();
        }
        return current;
    }
}
