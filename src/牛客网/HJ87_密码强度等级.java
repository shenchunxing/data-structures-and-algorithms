package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 */
public class HJ87_密码强度等级 {
    //可以，除了数字和字母真就全都是字符呗哈哈
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inputs;
        while((inputs=br.readLine())!=null)
        {
            /*数字数量*/
            int num=0;
            /*小写字母数量*/
            int lower=0;
            /*大写字母数量*/
            int upper=0;
            /*符号数量*/
            int symbol=0;
            /*分数*/
            int score=0;
            char[] input=inputs.toCharArray();
            for(int i=0;i<input.length;i++)//进行计数
            {
                if(input[i]<='9'&&input[i]>='0')
                    num++;
                else if(input[i]<='Z'&&input[i]>='A')
                    upper++;
                else if(input[i]<='z'&&input[i]>='a')
                    lower++;
                else
                    symbol++;
            }

            if(input.length<=4)//处理长度
                score+=5;
            else if(input.length<=7&&input.length>=5)
                score+=10;
            else if(input.length>=8)
                score+=25;

            if(lower==0&&upper==0)//处理字母
                score+=0;
            else if(upper!=0&&lower!=0)
                score+=20;
            else if(upper!=0||lower!=0)
                score+=10;

            if(num==0)//处理数字
                score+=0;
            else if(num==1)
                score+=10;
            else if(num>1)
                score+=20;

            if(symbol==0)//处理符号
                score+=0;
            else if(symbol==1)
                score+=10;
            else if(symbol>1)
                score+=25;

            /*奖励*/
            if(upper!=0&&lower!=0&&num!=0&&symbol!=0)
                score+=5;
            else if(upper+lower!=0&&num!=0&&symbol!=0)
                score+=3;
            else if((upper!=0||lower!=0)&&num!=0)//奖励
                score+=2;
            if(score>=90)
                System.out.println("VERY_SECURE");
            else if(score>=80)
                System.out.println("SECURE");
            else if(score>=70)
                System.out.println("VERY_STRONG");
            else if(score>=60)
                System.out.println("STRONG");
            else if(score>=50)
                System.out.println("AVERAGE");
            else if(score>=25)
                System.out.println("WEAK");
            else if(score>=0)
                System.out.println("VERY_WEAK");
        }
    }
}
