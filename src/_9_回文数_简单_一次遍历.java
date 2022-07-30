/**
 * https://leetcode.cn/problems/palindrome-number/
 */
public class _9_回文数_简单_一次遍历 {
    /**
     * 思路：翻转x的一半位数，O(logn) O(1)
     */
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0) return false;
        if (x == 0) return true;
        int revertedNumber = 0;
        //x > revertedNumber说明已经分离出了一半位数了)
        //revertedNumber每次在*19，x每次在/10
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;// x % 10 得到最后一位数字
            x = x / 10; //每轮循环分离出一个数
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     *  一次遍历o(n)
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int  rev = 0;
        int oldX = x;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            rev = rev * 10 + pop;
        }
        return rev == oldX;
    }
}
