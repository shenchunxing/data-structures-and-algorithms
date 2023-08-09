package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 */
public class HJ80_整型数组合并 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null){
            StringBuilder sb = new StringBuilder();
            /*数组1长度*/
            int n1 = Integer.parseInt(str);
            /*数组1*/
            String[] s1 = br.readLine().split(" ");
            /*数组2长度*/
            int n2 = Integer.parseInt(br.readLine());
            /*数组2*/
            String[] s2 = br.readLine().split(" ");
            int[] arr1 = new int[n1],arr2 = new int[n2];
            /*转成int数组*/
            for(int i=0;i<n1;i++) arr1[i] = Integer.parseInt(s1[i]);
            for(int i=0;i<n2;i++) arr2[i] = Integer.parseInt(s2[i]);
            int l1 = 0,l2 = 0;
            /*从小到大排序*/
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            /*依次遍历比较，添加到结果集中*/
            while(l1<n1 && l2<n2){
                if(arr1[l1]<arr2[l2]){
                    sb.append(arr1[l1]);
                    l1++;
                }else if(arr1[l1]>arr2[l2]){
                    sb.append(arr2[l2]);
                    l2++;
                }else{
                    /*相同情况下，l1、l2都++，去重了*/
                    sb.append(arr1[l1]);
                    l1++;
                    l2++;
                }
            }
            /*判断最后哪个先结束，未结束的拼接到后面即可*/
            while(l1<n1){
                sb.append(arr1[l1]);
                l1++;
            }
            while(l2<n2){
                sb.append(arr2[l2]);
                l2++;
            }
            System.out.println(sb.toString());
        }
    }
}
