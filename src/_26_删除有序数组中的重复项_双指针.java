/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 */
public class _26_删除有序数组中的重复项_双指针 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2,2,3}));
    }
    //双指针：一个指针扫描，一个指针填充
    static public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 1,fast = 1;//可以直接从第二个下标开始，因为第一个肯定可以填充
        while (fast <= nums.length - 1) {
            if (nums[fast] != nums[fast - 1]) { //不重复，指针填充
                nums[slow++] = nums[fast++];
            } else  { //重复了，只移动扫描指针
                fast++;
            }
        }
        return slow;
    }
}
