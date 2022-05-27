/**
 * https://leetcode.cn/problems/count-and-say/
 */
public class _38_外观数列 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    /**
     * 双指针
     */
    //本质上只是依次统计字符串中连续相同字符的个数
    static public String countAndSay(int n) {
        String str = "1";//第一个是"1"
        for (int i = 2; i <= n ; i++) {//从2开始遍历
            StringBuilder builder = new StringBuilder();
            //start表示开始统计的位置，pos表示相同字符的个数
            int start = 0, pos = 0;
            while (pos < str.length()) {
                //统计相同字符的个数
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                //pos - start是相同字符的长度
                //str.charAt(start) 是当前字符
                builder.append(Integer.toString(pos - start)).append(str.charAt(start));
                //开始位置重置成pos当前的位置
                start = pos;
            }
            str = builder.toString(); //每次循环结束，转成string，最后一次就是答案
        }
        return str;
    }
}
