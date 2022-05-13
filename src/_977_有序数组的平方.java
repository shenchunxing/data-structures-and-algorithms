/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author shenchunxing
 *
 */
public class _977_有序数组的平方 {
	/**
	 * 双指针,逆序填充
	 * @param nums
	 * @return
	 */
	//[-4,-1,0,3,10] -> [0,1,9,16,100]
	public int[] sortedSquares(int[] nums) {
		int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n - 1;
        int location = n - 1; //填充的位置
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[location] = nums[l] * nums[l];
                ++l;
            } else {
                ans[location] = nums[r] * nums[r];
                --r;
            }
            --location;
        }
        return ans;
    }

}
