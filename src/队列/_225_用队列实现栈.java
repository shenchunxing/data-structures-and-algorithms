package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈 {
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public class MyStack {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size -- ;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
