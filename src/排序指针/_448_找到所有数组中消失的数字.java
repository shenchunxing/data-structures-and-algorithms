package 排序指针;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author shenchunxing
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
 *
 */
public class _448_找到所有数组中消失的数字 {

	//1 , 2,2 ,4
	//5,6,6,8
	public List<Integer> findDisappearedNumbers(int[] nums) {
	   int n = nums.length;
	   for (int num : nums) {
		   int x = (num - 1) % n; //获取num 对应的下标
		   nums[x] += n; //更改下标为x的值，+n表示，num的值会大于n
	   }
	   
	   List<Integer> ret = new ArrayList<Integer>();
	   for (int i = 0; i < nums.length; i++) {
		   if (nums[i] <= n) { //如果发现小于等于n，说明该数不存在
			ret.add(i + 1);
		}
      }  
	   return ret;
	}
}
