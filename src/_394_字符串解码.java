import java.util.Collections;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * @author shenchunxing
 *
 */
public class _394_字符串解码 {
	int ptr = 0;
	public String decodeString(String s) {

		LinkedList<String> stk = new LinkedList<>();
		while (ptr < s.length()) {
		   char cur = s.charAt(ptr);
		   //如果是数字，则进栈
		    if(Character.isDigit(cur)) {
		    	String digitString = getDigits(s); 
		    	stk.add(digitString);
		    } else if (Character.isLetter(cur) || cur == '[') {
		    	//如果是字母，则进栈
		    	String string = String.valueOf(s.charAt(ptr++));
		    	stk.addLast(string);
		    } else {
		    	++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
		    }
		}
		
        return getString(stk);
    }
	
	public String getDigits(String s) {
	   StringBuffer buffer = new StringBuffer();
	   while (Character.isDigit(s.charAt(ptr))) {
		   buffer.append(s.charAt(ptr++));
	   }
	   return buffer.toString();
	}
	
	public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
