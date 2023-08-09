package 牛客网;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 */
public class _674_最长连续递增序列 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,6,8,7}));
    }
    static public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        /*start是第一个递增序列的起始坐标*/
        int start = 0;
        for (int i = 0; i < n; i++) {
            /*如果不是连续递增序列，重新设置起始位置*/
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            /*更新最大长度*/
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
