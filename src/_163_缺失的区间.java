import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/missing-ranges/
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 */
public class _163_缺失的区间 {
    public static void main(String[] args) {
        _163_缺失的区间 ob = new _163_缺失的区间();
        System.out.println(ob.findMissingRanges(new int[] {0,1,3,50,75},0,99));
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) { //边界条件
            res.add(help(lower - 1, upper + 1));
            return res;
        }
        if (lower < nums[0]) { //已存在的数的最小值都比开始区间大,添加缺失的区间【lower - 1 , nums[0]】
            res.add(help(lower - 1 , nums[0]));
        }
        //遍历数组
        for (int i = 0; i < n - 1 ; i++) {
            //说明缺失的区间是[nums[i],upper + 1]
            if (nums[i] + 1 != nums[i + 1]) {
                res.add(help(nums[i],nums[i + 1]));
            }
        }

        if (upper > nums[n - 1]) {
            res.add(help(nums[n - 1],upper + 1));
        }
        return res;
    }

    /**
     * 返回(left , right)的字符串,都是开区间
     *
     */
    private String help(int left , int right) {
        StringBuilder builder = new StringBuilder();
        if (left + 2 == right) { //中间只间隔了1个数
            builder.append(left + 1);
        } else { //中间间隔一组数
            builder.append(left + 1).append("->").append(right - 1);
        }
        return builder.toString();
    }
}
