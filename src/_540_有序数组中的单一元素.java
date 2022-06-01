/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 */
public class _540_有序数组中的单一元素 {
    public static void main(String[] args) {
        _540_有序数组中的单一元素 ob = new _540_有序数组中的单一元素();
        System.out.println(ob.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
    }
    /**
     * 二分搜索:整个数组长度是奇数，如果mid是偶数，比较mid和mid + 1。如果mid是奇数，比较mid和mid - 1
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            //如果mid是偶数，比较mid和mid + 1
            //如果mid是奇数，比较mid和mid - 1
            //利用异或，不用区分奇偶
            int value = mid % 2 == 0 ? nums[mid + 1] : nums[mid - 1];
            if (nums[mid] == value) { //nums[mid ^ 1]
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
