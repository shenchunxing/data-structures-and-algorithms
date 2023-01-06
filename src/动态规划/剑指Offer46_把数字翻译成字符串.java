package 动态规划;

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class 剑指Offer46_把数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
    //字符串的第i位置，可以单独作为一位来翻译
    //如果第i - 1位和第i位组成的数字在10-25之间，可以组合翻译
    //dp[i]表示以i结尾的翻译数
    //单独翻译的贡献数字是dp[i -1]
    //组合翻译的贡献是f[i - 2],此时第i - 1位和第i位组成的数字在10-25之间
    //因为翻译数只和dp[i - 1]、dp[i-2]有关，直接滚动数组优化
    static public int translateNum(int num) {
        char[] ch = String.valueOf(num).toCharArray();//转成字符数组
        int len = ch.length;
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++){
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if(n >= 10 && n <= 25){ //可以组合
                dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
            }else{
                dp[i % 2] = dp[(i - 1) % 2];
            }
        }
        return dp[len % 2];
    }

    public int translateNum2(int num) {
        char[] ch = String.valueOf(num).toCharArray();//转成字符数组
        int len = ch.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++){
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if(n >= 10 && n <= 25){ //可以组合
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
