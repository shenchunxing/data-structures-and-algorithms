/**
 * https://leetcode.cn/problems/decode-ways/
 */
public class _91_解码方法_中等_动态规划倒序遍历 {
    public int numDecodings(String s) {
        char[] nums = s.toCharArray();
        int[] dp = new int[nums.length + 1]; //第i个数到n的所有方案
        dp[nums.length] = 1;//最后一个字符,只有一种解
        //倒序
        for (int i = nums.length - 1; i <= 0 ; i--) {
            if (nums[i] == '0') continue;
            int num = 0;
            //每2个为一组
            for (int j = i; j < nums.length && j - i < 2 ; j++) {
                //求和
                num = num * 10 + nums[j] - '0';
                if (num < 26) {
                    dp[i] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}
