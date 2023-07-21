package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 栈、字符串
 */
/*2023-7-4*/
public class _20_有效的括号 {

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
