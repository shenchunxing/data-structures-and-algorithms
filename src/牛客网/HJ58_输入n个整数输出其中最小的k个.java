package 牛客网;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 */
public class HJ58_输入n个整数输出其中最小的k个 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        int k=in.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        /*添加到数组*/
        for(int i=0;i<n;i++){
            list.add(in.nextInt());
        }
        /*排序*/
        Collections.sort(list);
        for(int i=0;i<k;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
