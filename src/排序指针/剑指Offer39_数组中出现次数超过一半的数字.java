package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class 剑指Offer39_数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2})); //2
    }
    //投票法原理：众数是1。非众数-1，两两抵消后，剩余的还是众数
    //O(N) O(1)
    static public int majorityElement(int[] nums) {
        int x = 0 , votes = 0;
        for (int num : nums) {
            if (votes == 0) { //众数和非众数票数相同，抵消了，重新设置
                x = num;
            }
            votes += (num == x) ? 1 : - 1; //记票：和当前设定的值相同，就+1，否则-1
        }
        return x;
    }

    /**
     * 如果可能存在众数不存在的情况
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int x = 0 , votes = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) { //众数和非众数票数相同，抵消了，重新设置
                x = num;
            }
            votes += (num == x) ? 1 : - 1; //记票：和当前设定的值相同，就+1，否则-1
        }
        //这里得到了剩下的那个数votes，可能是众数也可能不是,统计超过一半的是众数，否则不是
        for (int num : nums) {
            if (x == num) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0; //0表示没有找到众数
    }

    //排序o(nlogn) O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
