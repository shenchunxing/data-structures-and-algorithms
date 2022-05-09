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
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

}
