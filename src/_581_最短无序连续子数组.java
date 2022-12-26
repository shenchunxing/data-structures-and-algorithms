/**
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class _581_最短无序连续子数组 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 8, 7, 9, 15}));
    }

    /**
     * 双指针一次遍历
     */
   static public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE, r = -1; //r指向右侧边界
        int min = Integer.MAX_VALUE, l = -1;//l指向左侧边界
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) { //r指向的是最后一个逆序对的位置
                r = i;
            } else { //保存最大值
                max = nums[i];
            }
            if (min < nums[n - i - 1]) { //l指向的是第一个逆序对的位置
                l = n - i - 1;
            } else { //保存当前最小的值
                min = nums[n - i - 1];
            }
        }
        return r == -1 ? 0 : r - l + 1;
    }
}
