/**
 * https://leetcode.cn/problems/plus-one/
 */
public class _66_加一_简单_倒序遍历每次加1判断是否为0 {
    public static void main(String[] args) {
        _66_加一_简单_倒序遍历每次加1判断是否为0 o = new _66_加一_简单_倒序遍历每次加1判断是否为0();
        System.out.println(o.plusOne(new  int[]{1,1,9}));
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        //倒叙遍历
        for (int i = n - 1; i >= 0 ; i--) {
            digits[i] = (digits[i] + 1) % 10; //digits[i]要么变成了0，要么变成了digits[i] + 1，一举两得
            if (digits[i] != 0) return digits; //说明并不是所有元素都是9，直接返回
        }

        //digits所有元素都是9，则创建新数组，第一位是1，其余全置位0
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    /**
     * digits最后有9，则找到第一个不是9的数字，+1，后面的9全部置0
     * digits所有元素都是9，则创建新数组，第一位是1，其余全置位0
     */
    public int[] plusOne2(int[] digits) {
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
