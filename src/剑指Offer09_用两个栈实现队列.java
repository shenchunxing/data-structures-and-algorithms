import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class 剑指Offer09_用两个栈实现队列 {
    class CQueue {
        Stack inStack = new Stack<Integer>(); //输入
        Stack outStack = new Stack<Integer>();//输出

        public CQueue() {

        }

        //从尾部入队
        public void appendTail(int value) {
            inStack.push(value);
        }

        //从头部出队
        public int deleteHead() {
            //如果输出栈是空的
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()){ //输入栈也是空的。返回-1
                    return -1;
                }
                while (!inStack.isEmpty()) { //将输入栈一个个pop出来，并push到输出栈
                    outStack.push(inStack.pop());
                }
            }
            //如果输出栈不是空的，直接pop
            return (int) outStack.pop();
        }
    }
}
