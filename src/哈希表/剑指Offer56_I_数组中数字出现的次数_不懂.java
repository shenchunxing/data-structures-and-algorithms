package 哈希表;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class 剑指Offer56_I_数组中数字出现的次数_不懂 {
    /**
     * 两个相同的数字进行异或操作，得到的是0。
     * 如果把只有1个数字，则全员异或，剩下的那个就是唯一的数字
     * 现在有2个这样的数字，将两个数字分在两个组中，两两配对的也分别在同一个组中，最后两个组全员异或得到的就是答案
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        //得到两个出现一次的数字的异或值a ^ b
        for (int n : nums) {
            ret = ret ^ n;
        }
        int div = 1;
        //在异或结果中找到任意为1的位
        while ((div & ret) == 0) {
            div <<= 1;//一直左移，直到遇到的是1，说明当前位a和b不相同，一个是1一个是0
        }
        //根据这找到的1位，对所有的数字进行分组:
        //将a、b分到不同的组中
        //因为数组中相同的数字，每一位都是相同的，所以肯定div & n == 0
        int a = 0 , b = 0;
        for (int n : nums) {
            if ((div & n) != 0) { //第一组,异或结束后，剩下的就是a
                a = a ^ n;
            } else  { //第二组，异或结束后，剩下的就是b
                b = b ^ n;
            }
        }
        return new int[] {a , b};
    }
}
