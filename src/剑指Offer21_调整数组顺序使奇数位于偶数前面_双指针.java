import java.util.Arrays;

/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class 剑指Offer21_调整数组顺序使奇数位于偶数前面_双指针 {
    public static void main(String[] args) {
       System.out.println(Arrays.toString(exchange(new int[] {1,2,3,4,5,6})));
    }
    //首尾双指针
    static public int[] exchange(int[] nums) {
        int l = 0 , r = nums.length - 1,temp;
        while (l < r) {
            //l从左到右搜索偶数
            //r从右到左搜索奇数
            //如果l < r说明，整个数组已经被扫描过了。条件不可缺少
            while (l < r && (nums[l] & 1) == 1) l++;//遇到的是奇数，继续，直到遇到偶数
            while (l < r && (nums[r] & 1) == 0) r--;//遇到的是偶数，继续，直到遇到奇数
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        return nums;
    }
}
