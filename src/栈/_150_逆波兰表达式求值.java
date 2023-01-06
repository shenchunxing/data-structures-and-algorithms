package 栈;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class _150_逆波兰表达式求值 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[] {"4","5","13","/","+"}));
    }

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
