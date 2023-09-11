package 牛客网;

import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号
 *
 * 输入描述
 *
 * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述
 *
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
 *
 * 输入
 *
 * 4
 *
 * 100 100 120 130
 *
 * 40 30 60 50
 *
 * 输出
 *
 * 2 1 3 4
 */
public class 按身高和体重排队 {
    static class Node implements Comparable<Node>{
        /*根据身高、体重、序号创建对象*/
        int i;
        int h;
        int w;
        Node(int i,int h,int w){
            this.i = i ;
            this.h = h ;
            this.w = w ;
        }

        /*比较器:身高优先，其次体重，最后是序号*/
        @Override
        public int compareTo(Node o){
            if(h != o.h)
                return h - o.h ;
            if(w!= o.w)
                return w - o.w ;
            return i - o.i;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in) ;
        while(in.hasNext()){
            int n = in.nextInt() ;
            int [] h = new int [n] ;
            int [] w = new int [n] ;
            for(int i = 0;i < n;i++){
                h[i] = in.nextInt() ;
            }
            for(int i = 0;i < n; i++){
                w[i]= in.nextInt();
            }
            Node[] nodes = new Node [n];
            /*创建对象并加入数组，序号从1开始*/
            for(int i = 0;i < n; i++){
                nodes[i] = new Node(i+1,h[i],w[i]);
            }
            /*排序*/
            Arrays.sort(nodes);
            for(int i =0;i<n;i++){
                System.out.printf("%d%c",nodes[i].i,1 == n-1 ? '\n':' ');
            }
        }
    }
}
