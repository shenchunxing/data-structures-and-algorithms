package 栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 难度：中等
 * 给你一个字符串数组 tokens ，表示一个根据逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
/*2023-7-14*/
public class _150_逆波兰表达式求值 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"4","5","13","/","+"}));
    }

    /**
     * 思路：需要逆向拿到每个操作符和操作数，用栈
     * 每次遇到一个操作符号，就pop出栈保存的两个操作数，并把结果保存回栈
     */
    static public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Integer op1,op2;
        for (String s : tokens) {
            switch (s) {
                //操作完一次后，都把结果push进去，保存
                case "+" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/" :
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default: //数字，就push进去
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
