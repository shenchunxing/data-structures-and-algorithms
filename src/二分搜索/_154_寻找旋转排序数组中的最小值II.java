package 二分搜索;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class _154_寻找旋转排序数组中的最小值II {
    public static void main(String[] args) {
        _154_寻找旋转排序数组中的最小值II o = new _154_寻找旋转排序数组中的最小值II();
        System.out.println(o.findMin(new int[] {7,0,1,1,1,1,1,2,3,4}));
    }
    public int findMin(int[] nums) {
        //nums可以被分割成2个数组，nums1里面的所有值都>=nums2里面的所有值
        int left = 0 , right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) { //mid在nums1中,最小值在nums2中
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { //mid在nums2中，最小值在nums1中
                right = mid;
            } else { //因为存在重复元素，无法确定mid在哪个组
                right = right - 1; //缩小范围,不会丢失最小值
            }
        }
        return nums[left];
    }
}
