package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 数据范围：输入的数据满足 4 \le n \le 1000 \4≤n≤1000
 */
public class HJ60_查找组成一个偶数最接近的两个素数 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content ;
        while(null != (content = br.readLine())){
            int num = Integer.parseInt(content);
            /*从num/2开始倒序*/
            for(int i = num/2;i>2;i--){
                /*检查i和num -i是否是素数，是就返回答案*/
                /*如果无法找到，就没输出*/
                if(check(i) && check(num-i)){
                    System.out.println(i);
                    System.out.println(num-i);
                    break;
                }
            }

        }
    }

    /*判断num是否是素数*/
    public static boolean check(int num){
        /*从2开始，i的平方取值，不大于num*/
        for(int i = 2;i*i<=num;i++){
            /*可以除尽，不是素数*/
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
