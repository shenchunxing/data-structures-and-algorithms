package 牛客网;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 数据范围：1 \leq n \leq 401≤n≤40
 * 要求：时间复杂度：O(n)O(n) ，空间复杂度： O(1)O(1)
 */
public class NC68_跳台阶 {
    public static void main(String[] args) throws IOException {
        System.out.println(jumpFloor(7));
    }

    public static int jumpFloor (int number) {
        int a = 1,b = 1,sum;
        for (int i = 0; i < number; i++) {
            sum = a + b;
            a = b ;
            b = sum;
        }
        return a;
    }
}
