package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/plus-one/
 * 难度：简单
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class _66_加一 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new  int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new  int[]{1,1,9})));
        System.out.println(Arrays.toString(plusOne(new  int[]{9,9,9})));
    }
   static public int[] plusOne(int[] digits) {
        int n = digits.length;
       /*倒叙遍历，
       1.如果遇到非'9'的情况，直接+1返回
       2.如果遇到'9'，当前位变成'0'，会再次循环，大一位的数+1.继续判断
       * */
        for (int i = n - 1; i >= 0 ; i--) {
            /*digits[i]要么变成了0，要么变成了digits[i] + 1*/
            digits[i] = (digits[i] + 1) % 10;
            //每一位加完就判断下，只要不是0，直接返回答案，
            //如果是0，继续遍历一轮
            if (digits[i] != 0) return digits; //说明并不是所有元素都是9，直接返回
        }

        /*进入到这里，表示原来数组元素都是'9'，而原来的数组元素经过for循环已经变成全部是'0'*/
       /*因此这里需要重新设置成多一位的数组，[1,0,0,0]*/
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    /**
     * digits最后有9，则找到第一个不是9的数字，+1，后面的9全部置0
     * digits所有元素都是9，则创建新数组，第一位是1，其余全置位0
     */
    static public int[] plusOne2(int[] digits) {
        int n = digits.length;
        //倒叙遍历
        for (int i = n - 1; i >= 0 ; i--) {
            if (digits[i] != 9) { //从后往前查找到第一个不是9的，直接+1，然后剩下的位全部置0
                digits[i]++;
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        //digits所有元素都是9，则创建新数组，第一位是1，其余全置位0
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
