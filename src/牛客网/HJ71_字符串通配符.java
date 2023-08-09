package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/5
 */
public class HJ71_字符串通配符 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=bf.readLine())!=null){
            /*因为题意要求不区分大小写，全部转成小写*/
            str=str.toLowerCase();
            String s=bf.readLine().toLowerCase();
            boolean [][] flag=new boolean[str.length()+1][s.length()+1];
            flag[0][0]=true;
            if(str.charAt(0)=='*'){
                flag[1][0]=true;
            }
            for(int i=1;i<=str.length();i++){
                char ch=str.charAt(i-1);
                for(int j=1;j<=s.length();j++){
                    char c=s.charAt(j-1);
                    /*?可以匹配一个任意字母或数字*/
                    if(ch=='?'){
                        /*如果当前待匹配的是数字或者字母，这样可以用?去匹配，说明在[i,j]位置是匹配的。此时[0,i]、[0,j]取决于flag[i-1][j-1]的值*/
                        if(check(c)){
                            flag[i][j]=flag[i-1][j-1];
                        }else{
                            flag[i][j]=false;
                        }
                        /*'*'可以匹配多个字母或数字，只要满足flag[i-1][j-1]、flag[i][j-1]、flag[i-1][j]三种中的一种就可以*/
                    }else if(ch=='*'){
                        if(check(c)){
                            flag[i][j]=flag[i-1][j-1]||flag[i][j-1]||flag[i-1][j];
                        }else{
                            flag[i][j]=false;
                        }
                    }else if(ch==c){
                        flag[i][j]=flag[i-1][j-1];
                    }else{
                        flag[i][j]=false;
                    }
                }
            }
            System.out.println(flag[str.length()][s.length()]);
        }
    }

    public static boolean check(char ch){
        if(ch>='a'&&ch<='z'||ch>='0'&&ch<='9'){
            return true;
        }
        return false;
    }
}
