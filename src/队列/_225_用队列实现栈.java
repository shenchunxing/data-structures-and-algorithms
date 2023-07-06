package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
/*2023-7-6*/
public class _225_用队列实现栈 {
    public static void main(String[] args) {
        _225_用队列实现栈 myStack = new _225_用队列实现栈();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
    }

    Queue<Integer> queue = new LinkedList<>();

   /*实现push其实就是先加到单端队列(先进先出)，然后一个个remove出来，并添加到stack上，此时变成了后进先出符合stack特性了*/
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
