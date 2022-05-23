/**
 * https://leetcode.cn/problems/qiu-12n-lcof/
 */
public class 剑指Offer64_求1至n的加法 {

    public int sumNums(int n) {
        //短路效应:&&字符，如果n > 1 为false，则不会执行(n + sumNums(n - 1)) > 0，这是递归的出口
        // n + sumNums(n - 1)
        // n -1  + sumNums(n - 2)
        // 2  + sumNums(1)
        // 1
        boolean x = n > 1 && (n + sumNums(n - 1)) > 0;
        return n;
    }
}
