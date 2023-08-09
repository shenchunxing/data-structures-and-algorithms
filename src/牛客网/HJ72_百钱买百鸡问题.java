package 牛客网;

import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 */
public class HJ72_百钱买百鸡问题 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            F(sc.nextInt());
        }
    }
    //解方程
    public static void F(int num) {
//        5x+3y+z/3=100;
//        x+y+z=100;
//        简化得 7x+4y=100;
        int x,y,z,middle;
        for(x = 0; x<=14;x++){
            if((100 - 7*x) % 4 == 0){
                y = (100 - 7*x) / 4;
                z = 100-x-y;
                System.out.print(x +" ");
                System.out.print(y +" ");
                System.out.print(z +" ");
                System.out.println();
            }
        }
    }
}
