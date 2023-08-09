package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 对字符串中的所有单词进行倒排。
 * 说明
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 */
public class HJ31_单词倒排 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            /*去除头尾空格，并转成字符数组*/
            char[] chs = str.trim().toCharArray();
            /*将非字母字符全部替换成空格*/
            for (int i = 0; i < chs.length; i++)
                if (!(chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z')) chs[i] = ' ';
            /*根据空格切割成单词*/
            String[] strs = String.valueOf(chs).split(" ");
            StringBuffer sb = new StringBuffer();
            /*倒序拼接单词*/
            for (int i = strs.length - 1; i >= 0; i--) {
                sb.append(strs[i]);
                /*如果不是最后一个，就需要拼接空格*/
                if (i > 0) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
