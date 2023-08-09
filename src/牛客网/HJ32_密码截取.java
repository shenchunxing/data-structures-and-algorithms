package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 */
public class HJ32_密码截取 {
    /*其实就是求最长回文子串*/
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        //中心扩散法
        while((str=bf.readLine())!=null){
            int max=0;
            for(int i=0;i<str.length()-1;i++){
                //ABA型
                int len1=longest(str,i,i);
                //ABBA型
                int len2=longest(str,i,i+1);
                /*每次更新最大长度*/
                max=Math.max(max,len1>len2?len1:len2);
            }
            System.out.println(max);
        }
    }

    /*ABA型：从i位置为中心，向两边扩展*/
    /*ABBA型：从i位置和j位置为中心，向两边扩展*/
    private static int longest(String str,int i,int j){
        while(j<str.length()&&i>=0&&str.charAt(i)==str.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
