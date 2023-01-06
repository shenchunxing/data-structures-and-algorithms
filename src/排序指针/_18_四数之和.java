package 排序指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 * @author shenchunxing
 *
 */
public class _18_四数之和 {
    public static void main(String[] args) {
        _18_四数之和 o = new _18_四数之和();
        System.out.println(o.fourSum(new int[] {0,0,0,1000000000,1000000000,1000000000,1000000000,
        1000000000},1000000000));
    }
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        Arrays.sort(nums);//排序
        int len = nums.length;
        //4数，什么数都没确定
        for (int i = 0; i < len - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //已经超过目标值，退出循环
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            //这一次循环不可能再大于target了，直接跳过
            if ((long)nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;

            //3数:已经确定了一个数num[i]
            //当前循环是nums[j]
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                //已经超过目标值，退出循环
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                //这一次循环不可能再大于target了，直接跳过
                if ((long)nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;

                //2数之和
                int left = j + 1 , right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) { //找到了，转成数组
                        ans.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
                        //继续去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;//无论如何，都移动一步
                        //去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
             }
        }
        return ans;
    }
}
