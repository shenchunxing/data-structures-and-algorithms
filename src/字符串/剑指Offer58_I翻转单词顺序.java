package 字符串;

/**
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
/*2023-7-7*/
public class 剑指Offer58_I翻转单词顺序 {
    public static void main(String[] args) {
       System.out.println(reverseWords("the sky is blue"));
    }

   static public String reverseWords(String s) {
        StringBuilder builder = trimSpaces(s);//去除多余空格
        reverse(builder , 0,builder.length() - 1);//翻转整个字符串
        reverseEachWord(builder); //翻转每个单词
        return builder.toString();
    }

    //去除头尾无用空格，单词之间只保留一个空格
    static private StringBuilder trimSpaces(String s) {
        int left = 0 , right = s.length() - 1;
        //去除头尾无用空格
        while (left <= right && s.charAt(left) == ' ') ++left;
        while (left <= right && s.charAt(right) == ' ') --right;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') sb.append(c); //如果不是空格， 直接拼接
            /*如果是空格，同时前一个不能是空格，这样做是为了确保两个单词之间最多只有1个空格*/
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            ++left;
        }
        return sb;
    }

    //翻转每个单词
    static private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') ++end; //遇到空格了，说明找到了一个单词，需要翻转了。此时end指向空格的位置
            reverse(sb,start,end - 1);//翻转单词，right是空格 - 1
            start = end + 1; //重新设置初始位置
            ++end;//不是空格end就每次前进一步
        }
    }

    //翻转指定区域的字符串
    static private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }
}
