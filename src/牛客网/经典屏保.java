package 牛客网;

import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 */
public class 经典屏保 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();
        /*方向*/
        int xDirection = 1, yDirection = 1;
        int width = 800, height = 600;
        for (int i = 0; i < t; i++) {
            if (x == 0) {
                //碰到最上层，x轴方向开始向下
                xDirection = 1;
            }
            if (y == 0) {
                //碰到最左侧，y轴方向开始向右
                yDirection = 1;
            }
            if (x + 50 == width) {
                //碰到最右侧，x轴方向开始向左（因为logo本身宽度是50）
                xDirection = -1;
            }
            if (y + 25 == height) {
                //碰到最下端，y轴方向向上（因为logo本身高度25）
                yDirection = -1;
            }
            x += xDirection;
            y += yDirection;
        }
        System.out.println(x + " " + y);
    }
}
