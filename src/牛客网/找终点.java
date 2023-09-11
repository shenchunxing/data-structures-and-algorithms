package 牛客网;

import java.util.Scanner;

/**
 * 给定一个正整数数组，设为nums，最大为100个成员，求从第一个成员开始，正好走到数组最后一个成员，所使用的最少步骤数。
 *
 * 要求：
 *
 * 第一步必须从第一元素开始，且1<=第一步的步长<len/2;（len为数组的长度，需要自行解析）。
 * 从第二步开始，只能以所在成员的数字走相应的步数，不能多也不能少, 如果目标不可达返回-1，只输出最少的步骤数量。
 * 只能向数组的尾部走，不能往回走。
 * 输入描述:
 *
 * 由正整数组成的数组，以空格分隔，数组长度小于100，请自行解析数据数量。
 * 输出描述:
 *
 * 正整数，表示最少的步数，如果不存在输出-1。
 *
 * 输入
 *
 * 7 5 9 4 2 6 8 3 5 4 3 9
 *
 * 输出
 *
 * 2
 */
public class 找终点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] eles = line.split(" ");
            int [] datas = new int[eles.length];
            for (int index = 0; index < eles.length; index++) {
                datas[index] = Integer.parseInt(eles[index]);
            }
            findPath(datas);
        }
    }
    private static void findPath(int[] datas) {
        /*最小步数*/
        int minStep = -1;
        int current = 0;
        /*题意第一步的步长1<= firstStep < datas.length / 2*/
        /*也就是说第一步可以走的幅度是1<= firstStep < datas.length / 2，因此需要循环*/
        for (int firstStep = 1; firstStep < datas.length / 2; firstStep++) {
            /*记录当前所在的位置*/
            current = firstStep;
            /*记录当前步数*/
            int step = 1;
            /*如果还没到终点,就继续走*/
            while (current < datas.length - 1) {
                /*更新位置*/
                current += datas[current];
                /*步数++*/
                step++;
            }
            /*需要正好到达终点*/
            if (current == datas.length - 1) {
                /*更新minStep*/
                if (minStep == -1) minStep = step;
                else if (minStep > step) minStep = step;
            }
        }
        System.out.println(minStep);
    }
}
