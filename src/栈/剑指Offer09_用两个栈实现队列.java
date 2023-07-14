package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 难度：简单
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
/*2023-7-14*/
public class 剑指Offer09_用两个栈实现队列 {
    public static void main(String[] args) {
        剑指Offer09_用两个栈实现队列 o = new 剑指Offer09_用两个栈实现队列();
        o.appendTail(1);
        o.appendTail(2);
        o.appendTail(3);

        System.out.println(o.deleteHead());
        System.out.println(o.deleteHead());
        System.out.println(o.deleteHead());
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //尾部入队
    public void appendTail(int value) {
        stack1.push(value);
    }
    //头部出队，打印出队的值
    public int deleteHead() {
        /*栈2有数据，就pop栈2*/
        if (stack2.isEmpty()) {
            /*已经是空栈了*/
            if (stack1.isEmpty()) return -1;
            /*将栈1的数据全部push到栈2*/
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
