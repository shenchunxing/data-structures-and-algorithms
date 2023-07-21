package 排序指针;

/**
 * https://leetcode.cn/problems/count-and-say/
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */
public class _38_外观数列 {
    public static void main(String[] args) {
//        System.out.println(countAndSay(4));//1211
//        System.out.println(countAndSay(5));//111221
        System.out.println(countAndSay(6));//312211
    }

    //本质上只是依次统计字符串中连续相同字符的个数
    static public String countAndSay(int n) {
        /*递归出口*/
        if (n == 1) return "1";
        /*递归：拿到前n - 1项的描述字符串，比如5，是111221*/
        String s = countAndSay(n - 1);
        int count = 1;
        String ans = "";
        /*解释第n - 1项，注意这里的i是从1开始的，因为要比较上一个值，但是i又不能取==s.length(),导致最后一项没有被统计。*/
        for (int i = 1; i < s.length(); i++) {
            /*字符连续相同,增加计数*/
            if (s.charAt(i) == s.charAt(i - 1)) count ++;
            else {
                /*不相同，得到字符的数量和字符*/
                ans += (count + "" + s.charAt(i - 1));
                /*重置计数*/
                count = 1;
            }
        }
        /*注意：ans是对前n - 1项的描述字符串。循环结束后，还需要将最后一组字符的信息添加到 ans 中，这是因为循环结束时并没有添加最后一组字符的信息。*/
        return ans + count + "" + s.charAt(s.length() - 1);
    }
}
