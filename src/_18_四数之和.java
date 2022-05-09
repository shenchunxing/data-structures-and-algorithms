import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 * @author shenchunxing
 *
 */
public class _18_四数之和 {
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums); //排序
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
        	
        	//重复项不计入
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //说明已经超出了，跳出循环，返回答案
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            
           //这次循环的最大情况都不符合，没必要继续下去了，直接进入下一个循环
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            //从i下一个开始，这里开始是三数之和
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //超出查找范围了，直接跳出循环
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //这次循环的最大情况都不符合，没必要继续下去了，直接进入下一个循环
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                //left是j的下一个 ， right是最后一个
                //这里开始变成了两数之和
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) { //找到了
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) { //过滤掉重复项
                            left++;
                        }
                        left++;//找到了答案，往右前进一步
                        while (left < right && nums[right] == nums[right - 1]) { //过滤掉重复项
                            right--;
                        }
                        right--; //找到了答案，往左前进一步
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
	}
}
