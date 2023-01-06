package 队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 
 * @author MJ
 *
 */
public class _239_滑动窗口最大值 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow_deque(new int[]{1,3,-1,-3,5,3,6,7},3)));
	}

	//单调队列
   static public int[] maxSlidingWindow_deque(int[] nums, int k) {
	   if (nums.length == 0 || nums == null || k <1) return new int[0];
	   if (k == 1) return nums;
	   //滑动窗口：保证当前对头元素是滑动窗口最大值
	   int[] maxNums = new int[nums.length - k + 1];
	   Deque<Integer> deque = new LinkedList<Integer>();
	   for (int i = 0; i < nums.length; i++) {
		   //维护队列单调递减，nums[队尾] <= nums[i]，就删除队尾
		   while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
			   deque.pollLast();
		   }
		   //将i加到队尾
		   deque.offerLast(i);
		   //检查窗口索引是否合法
		   int w = i - k + 1;
		   if (w < 0) continue;

		   //检查队头合法性
		   if (w > deque.peekFirst()) {
			   //队头的索引不合法，需要削掉
			   deque.pollFirst();
		   }

		   //设置窗口最大值（最大值就是队头）
		   maxNums[w] = nums[deque.peekFirst()];

	   }
	   return maxNums;
    }

	/**
	 * 暴力法
	 * @param nums
	 * @param k
	 * @return
	 */
	static public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) return new int[0];
		if (k == 1) return nums;

		int[] maxes = new int[nums.length - k + 1];
		// 当前滑动窗口的最大值索引
		int maxIdx = 0;
		// 求出前k个元素的最大值索引
		for (int i = 1; i < k; i++) {
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}

		// li是滑动窗口的最左索引
		for (int li = 0; li < maxes.length; li++) {
			// ri是滑动窗口的最右索引
			int ri = li + k - 1;
			if (maxIdx < li) { // 最大值的索引不在滑动窗口的合理范围内
				// 求出[li, ri]范围内最大值的索引
				maxIdx = li;
				for (int i = li + 1; i <= ri; i++) {
					if (nums[i] > nums[maxIdx]) maxIdx = i;
				}
			} else if (nums[ri] >= nums[maxIdx]) { // 最大值的索引在滑动窗口的合理范围内
				maxIdx = ri;
			}
			maxes[li] = nums[maxIdx];
		}

		return maxes;
	}
}
