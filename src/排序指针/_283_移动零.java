package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 难度：中等
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class _283_移动零 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * i是扫描，k是可以填充的位置，从0开始。填充了，k就++，填充完，后面的数都用0填充
     */
    static public void moveZeroes3(int[] nums) {
        int k = 0;
        //扫描一次，将非0的放到前面
        for(int x : nums) {
            if (x !=0) {
                nums[k] = x;
                k++;
            }
        }
        //再扫描一次，k后面的都填充0
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
    
   //双指针
    static public void moveZeroes2(int[] nums) {
    	if (nums == null) return;
    	int left = 0;//表示可以交换的0的位置
    	int right = 0;//非0位置
    	for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swapNums(left , right,nums);
				left++;
			}
			right++;
		}
    }

    static private void swapNums(int left , int right , int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}


    //填充
    static public void moveZeroes(int[] nums) {
        if (nums == null) return;
        for (int i = 0, cur = 0; i < nums.length; i++) {
            /*遇到0，直接跳过*/
            if (nums[i] == 0) continue;
            /*如果cur != i，表示前面出现过0了，把0的位置用i的值替换掉，然后把i的值变成0*/
            if (cur != i) {
                nums[cur] = nums[i]; //将i的值赋值给cur，同时i的值变成0
                nums[i] = 0;
            }
            cur++;
        }
    }
}
