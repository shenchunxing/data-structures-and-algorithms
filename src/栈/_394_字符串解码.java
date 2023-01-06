package 栈;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * @author shenchunxing
 *
 */
public class _394_字符串解码 {
	public static void main(String[] args) {
		_394_字符串解码 ob = new  _394_字符串解码();
//		System.out.println(ob.decodeString("3[a]2[bc]"));
		System.out.println(ob.decodeString("3[a2[c]]"));
	}
	/**
	 * 栈：括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应
	 * O(n) O(n)
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		int multi = 0; //乘数
		LinkedList<Integer> stack_muti = new LinkedList<>(); //保存上一次的乘数
		LinkedList<String> stack_res = new LinkedList<>(); //保存上一次统计的结果，答案的一部分
		for (Character c : s.toCharArray()) {
			//当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
			if (c >= '0' && c <= '9') {
				multi = multi * 10 + Integer.parseInt(c + "");
				//当 c 为字母时，在 res 尾部添加 c；
			} else if (c >= 'a' && c <= 'z') {
				res.append(c);
			}
			//当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置0
			else if (c == '[') {
				stack_muti.add(multi);
				stack_res.add(res.toString());
				multi = 0;
				res = new StringBuilder();
				//当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res
			} else if (c == ']') {
				StringBuilder tmp = new StringBuilder();
				//拿到当前乘数
				int cur_multi = stack_muti.removeLast();
				//拼接cur_multi个res：3a = aaa
				for (int i = 0 ; i < cur_multi ;i ++) {
					tmp.append(res);
				}
				//得到一部分结果
				res = new StringBuilder(stack_res.removeLast() + tmp);
			}
		}
		return res.toString();
	}
}
