package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 */
public class HJ51_输出单向链表中倒数第k个结点 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine())!=null){
            /*链表长度*/
            int num = Integer.parseInt(str);
            /*链表节点数组*/
            String[] numStr = br.readLine().split(" ");
            /*倒数第k个节点*/
            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(numStr[numStr.length-k]);
        }
    }
}
