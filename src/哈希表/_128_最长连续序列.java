package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 */
public class _128_最长连续序列 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));//4
    }

    //时间空间复杂度都是O(n)
   static public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        /*将所有num添加到哈希表中*/
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        /*遍历每个元素，查看当前元素的前一个元素和后一个元素是否存在
        1.如果前一个元素不存在，则说明当前就是第一个元素，默认长度是1，继续查看是否存在下一个元素
        2.如果前一个元素存在，则当前元素是前一个元素的后续元素，已经包含在1中了。
        * */
        for (int num : set) {
            //如果不包含前一个数字，说明从当前num开始是最长的起始位置
            if (!set.contains(num - 1)) {
                int currentNum = num;//指向当前值的指针
                int currentStreak = 1;//统计当前num下的最长连续序列长度
                //循环判断是否包含currentNum+1，如果包含则currentStreak+1，当前值指针指向currentNum+1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak ,currentStreak);
            }
        }

        return longestStreak ;
    }
}
