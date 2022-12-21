/**
 * https://leetcode.cn/problems/decode-ways/
 */
public class _91_解码方法_中等_动态规划倒序遍历 {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
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
