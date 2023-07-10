package 排序指针;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/missing-ranges/
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 */
/*2023-7-10 会员题*/
public class _163_缺失的区间 {
    public static void main(String[] args) {
        System.out.println(findMissingRanges(new int[] {0,1,3,50,75},0,99));//[2, 4->49, 51->74, 76->99]
    }
    static public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        /*排序数组为空，则缺失的就是整个[lower,upper]*/
        if (n == 0) {
            res.add(help(lower - 1, upper + 1));
            return res;
        }
        /*排序数组的最小值大于upper,添加缺失的区间(nums[lower - 1] , nums[0])*/
        if (lower < nums[0]) {
            res.add(help(lower - 1 , nums[0]));
        }
        //遍历数组
        for (int i = 0; i < n - 1 ; i++) {
            //说明缺失的区间是[nums[i],nums[i + 1]]
            if (nums[i] + 1 != nums[i + 1]) {
                res.add(help(nums[i],nums[i + 1]));
            }
        }
        /*排序数组的最大值小于upper,添加缺失的区间(nums[n - 1] , nums[upper + 1])*/
        if (upper > nums[n - 1]) {
            res.add(help(nums[n - 1],upper + 1));
        }
        return res;
    }

    /**
     * 返回(left , right)的字符串,都是开区间
     */
    static private String help(int left , int right) {
        StringBuilder builder = new StringBuilder();
        /*中间只间隔了1个数*/
        if (left + 2 == right) {
            builder.append(left + 1);
            /*中间间隔多个数*/
        } else {
            builder.append(left + 1).append("->").append(right - 1);
        }
        return builder.toString();
    }
}
