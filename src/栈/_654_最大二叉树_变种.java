package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 
 * @author MJ
 *
 */
public class _654_最大二叉树_变种 {
	public static void main(String[] args) {
		_654_最大二叉树_变种 o = new _654_最大二叉树_变种();
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		System.out.println(Arrays.toString(o.parentIndexes(nums)));
	}

    //题目变种：返回一个数组，数组里面存放的是父节点的索引
    //找左边第一个比它大的，找右边第一个比它大的。取较小的那个
    //保证栈是单调递减的
    public int[] parentIndexes(int[] nums) {
    	if (nums == null || nums.length == 0) return null;
    	/*
    	 * 1.扫描一遍所有的元素
    	 * 2.保持栈从栈底到栈顶是单调递减的
    	 */
    	int[] lis = new int[nums.length];
    	int[] ris = new int[nums.length];
    	Stack<Integer> stack = new Stack<>();
    	// 初始化-1，表示左右没有找到第一个比它大的
    	for (int i = 0; i < nums.length; i++) {
			ris[i] = -1;
			lis[i] = -1;
		}
    	for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				ris[stack.pop()] = i; //找到了右边第一个比它大的
			}
			if (!stack.isEmpty()) {
				lis[i] = stack.peek(); //找到了左边第一个比它大的
			}
			stack.push(i);
		}

    	//到此为止：找到了每个值对应的 左边第一个比他大的索引列表和 右边第一个比他大的索引列表
    	
    	//找父节点的索引：左右列表当中值较小的那个，还要考虑边界情况
    	int[] pis = new int[nums.length];
    	for (int i = 0; i < pis.length; i++) {
    		if (lis[i] == -1 && ris[i] == -1) {
    			// i位置的是根节点
    			pis[i] = -1;
    			continue;
    		}
    		
    		if (lis[i] == -1) { //找不到左边第一个比它大的
				pis[i] = ris[i];
    		} else if (ris[i] == -1) { //找不到右边第一个比它大的
				pis[i] = lis[i];
    		} else if (nums[lis[i]] < nums[ris[i]]) { //取较小的那个
				pis[i] = lis[i];
			} else {
				pis[i] = ris[i];
			}
		}
    	return pis;
    }
}
