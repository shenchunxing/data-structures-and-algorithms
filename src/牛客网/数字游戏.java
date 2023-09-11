package 牛客网;

import java.util.Scanner;

/**
 * 小明玩一个游戏。系统发1+n张牌，每张牌上有一个整数。
 * 第一张给小明，后n张按照发牌顺序排成连续的一行。
 * 需要小明判断，后n张牌中，是否存在连续的若干张牌，其和可以整除小明手中牌上的数字。
 *
 * 输入描述
 *
 * 输入数据有多组，每组输入数据有两行，输入到文件结尾结束。
 * 第一行有两个整数n和m，空格隔开。m代表发给小明牌上的数字。
 * 第二行有n个数，代表后续发的n张牌上的数字，以空格隔开。
 *
 * 输出描述
 *
 * 对每组输入，如果存在满足条件的连续若干张牌，则输出1；否则，输出0
 * 补充说明：
 *
 * 1 <= n <= 1000
 * 1 <= 牌上的整数 <= 400000
 * 输入的组数，不多于1000
 * 用例确保输入都正确，不需要考虑非法情况。
 *
 * 输入：
 * 6 7
 * 2 12 6 3 5 5
 * 10 11
 * 1 1 1 1 1 1 1 1 1 1
 *
 * 输出
 * 1
 * 0
 */
public class 数字游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = sc.nextInt();
            }
            int preSum = 0;
            //是否满足条件
            boolean isTrue = false;
            //余数数组，默认都是0
            int[] yushu = new int[m];
            yushu[0] = 1;
            for (int i = 0; i < n; i++) {
                /*求前i项和*/
                preSum += ints[i];
                /*求余，得到余数*/
                preSum %= m;
                if (yushu[preSum] != 0) {
                    //前面有这个余数，说明可以进行整除
                    isTrue = true;
                    break;
                }
                /*保存余数*/
                yushu[preSum]++;
            }
            System.out.println(isTrue ? 1 : 0);
        }
    }
}
