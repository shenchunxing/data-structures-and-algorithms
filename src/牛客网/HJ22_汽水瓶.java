package 牛客网;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 *
 * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 */
public class HJ22_汽水瓶 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine())!= null){
            int g = 0;
            g = Integer.parseInt(str);
            /*如果是0，直接返回*/
            if(g == 0){
                return;
            }
            /*记录可以喝到的汽水数量*/
            int count = 0;

            while (g != 0){
                /*按照3空瓶还1汽水的比例，获得的汽水*/
                int f = g/3;
                count+=f;
                /*剩余的空瓶和喝完的汽水瓶*/
                g =g%3 +f;
                /*小于3，说明无法兑换了，退出循环，否则继续兑换*/
                if(g < 3){
                    break;
                }
            }
            /*如果刚好有2瓶，可以问老板借一空瓶，还可以喝到一瓶*/
            if(g==2){
                count+=1;
            }
            System.out.println(count);
        }
    }
}
