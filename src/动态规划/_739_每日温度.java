package 动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
 */
//倒推法的继续优化
/*2023-7-18*/
public class _739_每日温度 {
	public static void main(String[] args) {
		/*倒推法*/
		System.out.println(Arrays.toString(dailyTemperatures1(new int[] {73,74,75,71,69,72,76,73})));
		/*单调栈*/
		System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
	}

	// 单调递减栈，更好理解，倒推法不好理解
	static public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0) return null;
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < T.length; i++) {
			//栈是单调递减的找到了第一个比栈顶大的的元素
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				/*result[栈顶元素的下标] = 间距*/
				result[stack.peek()] = i - stack.peek();
				/*已经找到了，出栈*/
				stack.pop();
			}
			/*每个索引都要入栈*/
			stack.push(i);
		}
		return result;
	}

	// 倒推法
	static public int[] dailyTemperatures1(int[] T) {
		if (T == null || T.length == 0)
			return null;
		//values存储的是第一个升温的需要的天数
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
					values[i] = values[j] + j - i; // 相等的情况需要在原来values[j]的基础上加j - i天
					break;
				} else {
					j = j + values[j]; // 直接跳到第一个比j大的索引那里，然后继续和i比较
				}
			}
		}
		return values;
	}

	static public int[] dailyTemperatures2(int[] T) {
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
}
