package 栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class 剑指Offer09_用两个栈实现队列 {
    class CQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        public CQueue() {

        }
        //尾部入队
        public void appendTail(int value) {
            stack1.push(value);
        }
        //头部出队
        public int deleteHead() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
           return stack2.pop();
        }
    }
}
