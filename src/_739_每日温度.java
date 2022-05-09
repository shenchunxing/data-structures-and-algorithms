import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 
 * @author MJ
 *
 */

//倒推法的继续优化
public class _739_每日温度 {
	// 构建单调递减栈，单调栈里面存储索引，找到第一个比他大的，说明找到了栈顶的每日温度，然后出栈
	public int[] dailyTemperatures2(int[] T) {
		if (T == null || T.length == 0)
			return null;
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < T.length; i++) {
			//找到了栈顶元素的升温日，出栈
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				result[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}
		return result;
	}
	
	public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0)
			return null;
		int[] values = new int[T.length];
		for (int i = T.length - 2; i >= 0; i--) {
			int j = i + 1;
			while (true) {
				if (T[i] < T[j]) {
					values[i] = j - i;
					break;
				} else if (values[j] == 0) {
					values[i] = 0;
					break;
				}
				// 当T[i] == T[j]的时候
				j = j + values[j];
			}
		}
		return values;
	}

	// 倒推法：有点动态规划的味道
	public int[] dailyTemperatures1(int[] T) {
		if (T == null || T.length == 0)
			return null;
		int[] values = new int[T.length];
		for (int i = T.length - 2; i >= 0; i--) {
			int j = i + 1;
			while (true) {
				if (T[i] < T[j]) {
					values[i] = j - i; // 找到了
					break;
				} else if (values[j] == 0) { // 说明j右边没有更高的值 && T[i] > T[j]
					values[i] = 0;
					break;
				} else if (T[i] == T[j]) {
					values[i] = values[j] + j - i; // 相等的情况需要更新
					break;
				} else {
					j = j + values[j]; // 直接跳到第一个比j大的索引那里
				}
			}
		}
		return values;
	}
}
