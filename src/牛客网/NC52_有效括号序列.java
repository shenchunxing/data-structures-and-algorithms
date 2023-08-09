package 牛客网;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 数据范围：字符串长度 0\le n \le 100000≤n≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 */
public class NC52_有效括号序列 {

    //原理：遇到了右括号，则必须和栈顶的左括号匹配，匹配成功后，移除掉，否则就是false
    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }

    static public boolean isValid(String s) {
        if (s == null || s.length() ==0 ) return false;
        if (s.length() % 2 != 0) return false;//奇数肯定不是有效的
        /*记录括号的对应关系*/
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { //取出任意一个右括号
                /*如果栈为空或栈顶元素不是对应的左括号，不是有效的*/
                if (stack.isEmpty() || map.get(c) != stack.peek())  return false;
                stack.pop(); //出栈
            } else { //左括号入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
