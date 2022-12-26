/**
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class 剑指Offer10_II_青蛙跳台阶问题 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
    //动态规划
   static public int numWays(int n) {
        //状态转移方程：f(n) = f(n - 1) + f(n - 2)
       //f(0) =1,f(1) = 1.f(2) = 2
        int a = 1,b = 1,sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007; //题目要求取余1000000007
            a = b ;
            b = sum;
        }
        return a;
    }
}
