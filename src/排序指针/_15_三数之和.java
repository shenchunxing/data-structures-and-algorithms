package 排序指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
/*2023-7-4*/
public class _15_三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,-1,0,1,1,2,-1,-4}));
    }
    //排序+ 双指针: 时间复杂度O(N^2),空间复杂度O(logN)
   static public List<List<Integer>> threeSum(int[] nums) {
        /*排序*/
        Arrays.sort(nums);
       /*k < nums.length - 2减少不必要的循环*/
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; //nums[k]是最小的数，最小的数都 > 0，不可能找到答案了
            if (k > 0 && nums[k] == nums[k - 1]) continue; //去重
            /*i从当前遍历的下一个值开始，j从尾部开始*/
            int i = k + 1 , j  = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                /*注意：在去重过程中要始终保持i < j 这个条件*/
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]); //因为sum<0。重复的值也是sum<0的。让i++，如果i++的值还是一样，继续++，直到不相等为止
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);//让j--，并去重
                } else {
                    /*得到一个答案,继续去重*/
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i < j && nums[i] == nums[++i]); //让i++，并去重
                    while (i < j && nums[j] == nums[--j]);//让j--，并去重
                }
            }
        }
        return  res;
    }

    //排序+ 双指针: 时间复杂度O(N^2),空间复杂度O(logN)
    public List<List<Integer>> threeSum0(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        // 排序
        Arrays.sort(nums);

        // i用来扫描三元组的第一个元素
        int lastIdx = nums.length - 3;
        int lastR = nums.length - 1;
        for (int i = 0; i <= lastIdx; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            /*l是左边界，r是右边界，remain表示剩余的值*/
            int l = i + 1, r = lastR, remain = -nums[i];
            while (l < r) {
                /*左右边界求和*/
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) { // 找到了符合条件的三元组
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 跳过相同的值（去重）
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    //因为此时的l和r是符合条件的。且已经去重了，大胆同时往中间逼近
                    l++;
                    r--;
                } else if (sumLr < remain) { //说明在当前i的位置，左侧位置的值太小了，需要往中间逼近
                    l++;
                } else { // sumLr > remain
                    r--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        // negSize：负数的数量
        // posSize：正数的数量
        // zeroSize：0的数量
        int negSize = 0, posSize = 0, zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }
            if (v > 0) {
                posSize++;
            } else if (v < 0) {
                negSize++;
            } else {
                zeroSize++;
            }
        }
        if (zeroSize >= 3) { // 超过3个0
            list.add(Arrays.asList(0, 0, 0));
        }
        // 如果没有负数或没有正数
        if (negSize == 0 || posSize == 0) return list;

        // 排除掉边界不可能凑成0的数（过大或过小的数）
        if ((minValue << 1) + maxValue > 0) { // [-3, -2, 0, 2, 5, 6, 7, 8, 9]
            maxValue = -minValue << 1;
        } else if ((maxValue << 1) + minValue < 0) { // [-9, -8, -7, -6, -5, -2, 0, 2, 3]
            minValue = -maxValue << 1;
        }

        // 存放每个数字v出现的次数，v对应下标为v - minValue
        int[] sizes = new int[maxValue - minValue + 1];
        int[] poses = new int[posSize]; // 存放所有的正数（已去重）
        posSize = 0;
        int[] negs = new int[negSize]; // 存放所有的负数（已去重）
        negSize = 0;
        for (int v : nums) {
            // 排除掉边界不可能凑成0的数（过大或过小的数）
            if (v < minValue || v > maxValue) continue;
            if (sizes[v - minValue]++ != 0) continue;
            if (v > 0) {
                poses[posSize++] = v;
            } else if (v < 0) {
                negs[negSize++] = v;
            }
        }
        // 只排序非0部分
        Arrays.sort(poses, 0, posSize);
        // 只排序非0部分
        Arrays.sort(negs, 0, negSize);

        int posBegin = 0;
        int nv;
        // 遍历负数数组（从绝对值最小的开始遍历）
        for (int ni = negSize - 1; ni >= 0; ni--) {
            nv = negs[ni];
            // 负数绝对值的一半
            int minPv = -nv >> 1;
            // 跳过 < minPv的正数
            // 如果 < minPv的正数可以和nv凑成0，会在遍历到 > minPv的正数时，倒回去找 < minPv的正数
            while (posBegin < posSize && poses[posBegin] < minPv) {
                posBegin++;
            }
            for (int pi = posBegin; pi < posSize; pi++) {
                int pv = poses[pi];
                int remain = -nv - pv; // 0 - nv - pv
                if (remain == nv) { // 还差一个nv，就凑够0
                    if (sizes[nv - minValue] > 1) {
                        list.add(Arrays.asList(nv, nv, pv));
                    }
                } else if (remain == pv) { // 还差一个pv，就凑够0
                    if (sizes[pv - minValue] > 1) {
                        list.add(Arrays.asList(nv, pv, pv));
                    }
                } else if (remain > nv && remain < pv) {
                    if (sizes[remain - minValue] > 0) { // 还差一个remain，就凑够0
                        list.add(Arrays.asList(nv, remain, pv));
                    }
                } else if (remain < nv) break; // 寻找绝对值更大的负数
            }
        }
        return list;
    }
}
