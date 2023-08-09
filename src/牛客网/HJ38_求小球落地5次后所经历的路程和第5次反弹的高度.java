package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/4
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 */
public class HJ38_求小球落地5次后所经历的路程和第5次反弹的高度 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            Double n = Double.parseDouble(str);
            double result = 0.0;
            /*result表示总走的行程*/
            result+= n ;
            /*n表示第5次反弹的高度*/
            n/=2;
            for(int i=1;i<5;i++){
                /*每次有弹起+落地，需要2n的行程*/
                result+= (2*n) ;
                /*然后n/2*/
                n/=2;
            }
            System.out.println(result+"\n"+n);
        }
    }
}
