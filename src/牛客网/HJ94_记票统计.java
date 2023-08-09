package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * （注：不合法的投票指的是投票的名字不存在n个候选人的名字中！！）
 *
 * 数据范围：每组输入中候选人数量满足
 * 1
 * ≤
 * n
 * ≤
 * 100
 *
 * 1≤n≤100  ，总票数量满足
 * 1
 * ≤
 * n
 * ≤
 * 100
 *
 * 1≤n≤100
 * 输入描述：
 *
 * 第一行输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 * 输出描述：
 *
 * 按照输入的顺序，每行输出候选人的名字和得票数量（以" : "隔开，注：英文冒号左右两边都有一个空格！），最后一行输出不合法的票数，格式为"Invalid : "+不合法的票数。
 */
public class HJ94_记票统计 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null){
            /*候选人数量*/
            int candidate = Integer.parseInt(str);
            /*候选人姓名数组*/
            String[] name = br.readLine().split(" ");
            /*投票人数量*/
            int voter = Integer.parseInt(br.readLine());
            /*投票结果*/
            String[] vote = br.readLine().split(" ");
            /*无效票数量*/
            int invalid = 0;
            int[] number = new int[candidate];
            for(int i=0; i<name.length; i++){
                for(int j =0; j<vote.length; j++){
                    /*投票结果和候选人匹配，指定候选人票数++*/
                    if(name[i].equals(vote[j])){
                        number[i]++;
                    }
                }
                /*每一轮投完票，总票数需要减去候选人的票数，这样全部投完票之后，剩余的就是无效的票*/
                voter -= number[i];
            }
            invalid = voter;
            /*打印结果*/
            for(int i=0; i<name.length; i++){
                System.out.println(name[i] + " : " + number[i]);
            }
            /*打印无效票*/
            System.out.println("Invalid : " + invalid);
        }
    }
}
