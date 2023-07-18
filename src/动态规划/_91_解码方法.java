package 动态规划;

/**
 * https://leetcode.cn/problems/decode-ways/
 * 难度:中等
 * 一条包含字母A-Z 的消息通过以下映射进行了编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数
 *
 * 思路：动态规划
 */
public class _91_解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));//BBF、UF、BZ
        System.out.println(numDecodings("11106"));//AAJF、KJF
    }
   static public int numDecodings(String s) {
       char[] nums = s.toCharArray();
       int[] dp = new int[nums.length + 1];//dp[i] 表示从第i+1个数到第n个数的所有方案数
       dp[nums.length] = 1; //最后一个值肯定只有1种方案
       for (int i = nums.length -1;i >= 0;i--) {
           if (nums[i] == '0') continue; // 当开始位为0字符时不满足任意一个字母的解析，跳过
           int num = 0 ;
           //每2个为一组,因为最大的组合就是26
           for (int j = i; j < nums.length && j - i < 2; j++) {
               //得到当前的值
               num = num * 10 + (nums[j] - '0');
               //上限不超过26，可以转移状态
               if (num <= 26) {
                   dp[i] = dp[i] + dp[j + 1];
               }
           }
       }
       return dp[0];
    }
}
