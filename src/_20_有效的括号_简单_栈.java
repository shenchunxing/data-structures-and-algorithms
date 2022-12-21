import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 */
public class _20_有效的括号_简单_栈 {

    //原理：遇到了右括号，则必须和栈顶元素匹配，匹配成功后，移除掉，否则就是false
	public static void main(String[] args) {
		_20_有效的括号_简单_栈 o = new _20_有效的括号_简单_栈();
		System.out.println(o.isValid("(("));
	}

	 public boolean isValid(String s) {
		 if (s == null || s.length() ==0 ) return false;
		 if (s.length() % 2 != 0) return false;//奇数肯定不是有效的
		 Map<Character, Character> map = new HashMap<>();
		 map.put('}', '{');
		 map.put(')', '(');
		 map.put(']', '[');
		 Stack<Character> stack = new Stack<>();
		 for (int i = 0; i < s.length(); i++) {
			 char c = s.charAt(i);
			 if (map.containsKey(c)) { //取出任意一个右括号
				 if (stack.isEmpty() || map.get(c) != stack.peek())  return false; //栈为空或栈顶元素不是对应的左括号，不是有效的
				 stack.pop(); //出栈
			 } else { //左括号入栈
				 stack.push(c);
			 }
		 }
		 return stack.isEmpty();
	 }
}
