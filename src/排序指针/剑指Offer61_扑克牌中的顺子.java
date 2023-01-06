package 排序指针;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class 剑指Offer61_扑克牌中的顺子 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[] {0,0,1,2,4}));
        System.out.println(isStraight2(new int[] {0,6,1,2,4}));
    }

    //暴力排序
    static public boolean isStraight2(int[] nums) {
        int joker = 0; //计算大小王的数量
        Arrays.sort(nums);
        for (int i = 0 ; i < 4 ;i++) {
            if (nums[i] == 0) joker++;
                // 重复
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5; //最大牌 - 最小牌(下标从大小王的下一张开始) < 5
    }

    //根据题意：1。5张牌必须没有重复
    // 2。5张牌最大值max - min < 5(大小王除外)
    //集合 + 遍历
    static public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;//min用14更合理，也可以使用大数
        for (int num : nums) {
            if (num == 0 ) continue;;
            max = Math.max(max,num);//找到最大值
            min = Math.min(min,num);//找到最小值
            if (set.contains(num)) return false;//存在重复
            set.add(num);
        }
        return (max - min) < 5;
    }


}
