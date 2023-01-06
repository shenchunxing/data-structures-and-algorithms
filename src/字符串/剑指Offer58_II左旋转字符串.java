package 字符串;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class 剑指Offer58_II左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords1("abcdefg",2));
    }
    //子串
    static public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) { //取模
            res += s.charAt( i % s.length());
        }
        return res;
    }

    //字符串拼接
    public String reverseLeftWords2(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int j = 0; j < n; j++) {
            builder.append(s.charAt(j));
        }
        return builder.toString();
    }
}
