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
		System.out.println(Arrays.toString(maxSlidingWindow_deque(new int[]{1,-1},1)));
	}

	//单调队列
   static public int[] maxSlidingWindow_deque(int[] nums, int k) {
	   int n = nums.length;
	   Deque<Integer> deque = new LinkedList<Integer>();
	   //维护一个单调队列，队列中的头部就是滑动窗口最大值
	   //前k个元素的最大值的索引
	   for (int i = 0; i < k; ++i) {
		   while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
			   deque.pollLast();
		   }
		   deque.offerLast(i);//队列中存储的是索引
	   }

	   int[] ans = new int[n - k + 1];
	   //拿到第一个答案
	   ans[0] = nums[deque.peekFirst()];
	   //开始滑动
	   for (int i = k; i < n; ++i) {
		   //和队尾比较，替换队尾的较小元素
		   while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
			   deque.pollLast();
		   }
		   deque.offerLast(i);
		   //超出范围了，需要重新维护队头索引
		   while (deque.peekFirst() <= i - k) {
			   deque.pollFirst();
		   }
		   ans[i - k + 1] = nums[deque.peekFirst()];
	   }
	   return ans;
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
