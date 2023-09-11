package 牛客网;

import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 小明和朋友玩跳格子游戏， 有 n 个连续格子组成的圆圈，每个格子有不同的分数，小朋友可以选择从任意格子起跳，但是不能跳连续的格子，不能回头跳，也不能超过一圈 ;
 *
 * 给定一个代表每个格子得分的非负整数数组，计算能够得到的最高分数。
 *
 * 输入描述
 *
 * 给定一个数例，第一个格子和最后一个格子收尾相连，如：2 3 2
 *
 * 输出描述
 *
 * 输出能够得到的最高分，如：3
 */
public class 跳格子2 {
    /*leetcode 小偷偷窃*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        //包含第一个数字，不包含最后一个数字
        int[] numsStart = new int[strings.length - 1];
        //不包含第一个数，包含最后一个数
        int[] numsEnd = new int[strings.length - 1];
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(strings[i]);
            if (i == 0) {
                numsStart[i] = num;
                continue;
            }
            if (i == len - 1) {
                numsEnd[i - 1] = num;
                break;
            }
            numsStart[i] = num;
            numsEnd[i - 1] = num;
        }
        int res = Math.max(handle(numsStart), handle(numsEnd));
        System.out.println(res);
    }
    /**
     * 动态规划 d[i] = Math.max( dp[i-1], dp[i-2] + nums[i])
     *
     * @param nums
     * @return
     */
    public static int handle(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }
}
