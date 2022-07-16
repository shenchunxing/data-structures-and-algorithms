/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * @author MJ
 *
 */
public class _75_颜色分类_中等_三指针 {

	///3指针
    public void sortColors(int[] nums) {
		//i扫描 ，l是0填充的位置，r是2填充的位置
		int l = 0 , r = nums.length - 1 , i = 0;
		while (i <= r) {
			if (nums[i] == 0) swap(l++,i++,nums);
			else if (nums[i] == 1) i++;
			else swap(i,r--,nums);
		}
	}

	private void swap(int l , int r , int[] nums) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}
