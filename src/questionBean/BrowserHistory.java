package questionBean;

import java.util.Stack;

/**
 * 1472. 设计浏览器历史记录
 * 对于此浏览器，必定使用栈结构完成业务功能；那么可以维护两个不同的栈，用其存储对应的两个不同步骤下的内容
 * <p>
 * 当然，我们还可以仅使用单个栈，并维护一个坐标，用其标识当前所处位置。visit操作时，首先弹出坐标往上的所有值，再加入访问的页面值。
 */
public class BrowserHistory {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();

    public BrowserHistory(String homepage) {
        forwardStack.push(homepage);
        backStack.clear();
    }

    public void visit(String url) {
        forwardStack.push(url);
        backStack.clear();
    }

    public String back(int steps) {
        int realStep = steps;
        if (steps >= forwardStack.size()) {
            realStep = forwardStack.size() - 1;
        }
        for (int i = 0; i < realStep; i++) {
            String backUrl = forwardStack.pop();
            backStack.push(backUrl);
        }
        return forwardStack.peek();
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (backStack.empty()) break;
            String backUrl = backStack.pop();
            forwardStack.push(backUrl);
        }
        return forwardStack.peek();
    }
}
