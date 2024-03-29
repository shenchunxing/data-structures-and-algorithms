package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 喊7是一个传统的聚会游戏，N个人围成一圈，按顺时针从1到N编号。
 *
 * 编号为1的人从1开始喊数，下一个人喊的数字为上一个人的数字加1，但是当将要喊出来的数字是7的倍数或者数字本身含有7的话，不能把这个数字直接喊出来，而是要喊”过”。
 *
 * 假定玩这个游戏的N个人都没有失误地在正确的时机喊了”过”，当喊到数字K时，可以统计每个人喊”过”的次数。
 *
 * 现给定一个长度为N的数组，存储了打乱顺序的每个人喊”过”的次数，请把它还原成正确的顺序，即数组的第i个元素存储编号i的人喊”过”的次数。
 *
 * 输入描述
 *
 * 输入为一行，为空格分隔的喊”过”的次数，注意K并不提供，K不超过200，而数字的个数即为N。
 *
 * 输出描述
 *
 * 输出为一行，为顺序正确的喊”过”的次数，也由空格分隔。
 */
public class 喊7的次数重排 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] s1 = s.split(" ");
        int count = 0;
        for (String value : s1) {
            count += Integer.parseInt(value);
        }
        int num = 6;
        for (int j = 0; j < count; ) {
            num++;
            if (num % 7 == 0 || (num + "").contains("7")) {
                j++;
            }
        }
        int[] arr = new int[s1.length];
        for (int i = 1; i <= num; i++) {
            if (i % 7 == 0 || (i + "").contains("7")) {
                arr[i % s1.length]++;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[0]);
    }
}
