package 哈希表;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/4sum-ii/
 * 难度：中等
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class _454_四数相加II {
    public static void main(String[] args) {
        System.out.println(fourSumCount(
                new int[] {1,2},new int[] {-2,-1},new int[] {-1,2},new int[] {0,2})
        );
    }

    static public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();

        //记录前2个数组的正数和，以及出现的次数
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }

        int count = 0;
        //记录后2个数组的负数和，以及出现的次数
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                /*取反*/
                int sum = -nums3[i] - nums4[j];
                /*得到匹配为0的情况，同时拿到了匹配的次数*/
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }
}
