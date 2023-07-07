package 字符串;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
/*2023-7-4*/
public class 剑指Offer58_II左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords1("abcdefg",2));
        System.out.println(reverseLeftWords2("abcdefg",2));
        System.out.println(reverseLeftWords("abcdefg",2));
    }
    //直接使用API获取子串
    static public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }

    /*取模*/
    static public String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) { //取模
            res += s.charAt( i % s.length());
        }
        return res;
    }

    //字符串拼接
    static public String reverseLeftWords2(String s, int n) {
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
