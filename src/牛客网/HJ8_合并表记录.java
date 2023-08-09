package 牛客网;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 */
public class HJ8_合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i < n; i++){
            /*拿到输入的key和value*/
            int a = in.nextInt();
            int b = in.nextInt();
            /*哈希表为空，或者不存在，就新建*/
            if(map.isEmpty() || !map.containsKey(a)){
                map.put(a,b);
            }
            /*已经存在，就拿到value，合并覆盖*/
            else if(map.containsKey(a)){
                int temp = map.get(a);
                map.put(a,temp + b);
            }
        }
        //拿到key的数组，根据key排序
        Set set = map.keySet();
        Object[] a1 = set.toArray();
        Arrays.sort(a1);

        /*打印数组*/
        for(Object key : a1){
            System.out.println(key + " " + map.get(key));
        }
    }
}
