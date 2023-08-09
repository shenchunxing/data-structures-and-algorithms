package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 *
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 *
 * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
 * 输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述：
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 */
public class HJ63_DNA序列 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = bf.readLine())!=null){
            /*子序列长度*/
            int num = Integer.parseInt(bf.readLine());
            int count = 1;
            /*GC数量*/
            int max = 1;
            /*起始索引*/
            int left = 0;
            /*因为需要长度是num，边界取i<str.length()-num*/
            for(int i = 1;i<str.length()-num;i++){
                /*注意思考：pre是子序列的前一个字符，如果是'G'或者'C',说明这次循环没有包含进去，损失了，需要count--，肯定不会是最大值*/
                /*还是不是很理解*/
                char pre = str.charAt(i-1);
                char next = str.charAt(i+num-1);
                if(pre=='G'||pre=='C')
                    count--;
                /*next是子序列的最后一个字符*/
                if(next=='G'||next=='C')
                    count++;
                /*当前GC数量更大，更新max，并重新设置边界*/
                if(count>max){
                    max = count;
                    left = i;
                }
            }
            /*以left为起始索引的子串*/
            System.out.println(str.substring(left,left+num));
        }
    }
}
