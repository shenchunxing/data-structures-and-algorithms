/**
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class 剑指Offer58_I翻转单词顺序 {
    public String reverseWords(String s) {
        StringBuilder builder = trimSpaces(s);//去除多余空格
        reverse(builder , 0,builder.length() - 1);//翻转整个字符串
        reverseEachWord(builder); //翻转每个单词
        return builder.toString();
    }

    //去除空格
    private StringBuilder trimSpaces(String s) {
        int left = 0 , right = s.length() - 1;
        //去除头尾空格
        while (left <= right && s.charAt(left) == ' ') ++left;
        while (left <= right && s.charAt(right) == ' ') --right;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') sb.append(c); //如果不是空格， 直接拼接
            else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);//如果是空格，需要拼接在最后，同时不能拼接多个空格
            ++left;
        }
        return sb;
    }

    //翻转指定区域的字符串
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }

    //翻转每个单词
    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') ++end; //遇到空格，停一下。end指向空格的位置
            reverse(sb,start,end - 1);//翻转单词，right是空格 - 1
            start = end + 1; //重新设置初始位置
            ++end;//不是空格end就每次前进一步
        }
    }
}
