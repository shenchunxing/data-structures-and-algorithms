import java.util.Arrays;

/**
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class 剑指Offer17_打印从1到最大的n位数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }

    static public int[] printNumbers(int n) {
        //最大的数
        int end = (int)Math.pow(10,n) - 1;
        int[] nums = new int[end];
        for (int i = 0; i < end; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
