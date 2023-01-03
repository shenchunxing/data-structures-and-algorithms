/**
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class 剑指Offer15_二进制中1的个数_位运算 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }
    //O(log2n) O(1)
    static public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n = n >>> 1;//java无符号右移 >>>
        }
        return ans;
    }

    //O(M) O(1)
    //位运算优化，很取巧的方法
    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            /**
             * 6:110 n
             * 5:101 n-1
             * 4:100
             * 恰好把n最低位的1变成了0，这样即可统计1的位数了
             */
            n &= n - 1;
        }
        return res;
    }
}
