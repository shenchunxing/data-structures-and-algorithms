/**
 * https://leetcode.cn/problems/count-and-say/
 */
public class _38_外观数列_中等_双指针统计相同字符的个数 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));//1211
        System.out.println(countAndSay(6));//312211
    }

    //本质上只是依次统计字符串中连续相同字符的个数
    static public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n ; i++) {
            StringBuilder builder = new StringBuilder();
            //开始位置
            int start = 0 , position = 0;//当前位置
            while (position < str.length()) {
                //统计连续相同的长度
                while (position < str.length() && str.charAt(start) == str.charAt(position)) {
                    position++;
                }
                builder.append(Integer.toString(position - start)).append(str.charAt(start));
                //重置位置
                start = position;
            }
            str = builder.toString();
        }
        return str;
    }
}
