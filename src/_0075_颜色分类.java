/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * @author MJ
 *
 */
public class _0075_颜色分类 {

	///3指针
    public void sortColors(int[] nums) {
    	int i = 0; //用于扫描
    	int l = 0; //指向0的位置
    	int r = nums.length - 1;//指向2的位置
    	while (i <= r) {
    		if (nums[i] == 0) { //0放左边
    			swap(nums, i++, l++); //交换i和l的值，然后i++，
    		} else if (nums[i] == 1) { //1保持不动
    			i++;
    		} else { //2放右边
    			swap(nums, i, r--);//交换i和的值，然后r--，
    		}
    	}
    }
    
    //交换两个值
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
