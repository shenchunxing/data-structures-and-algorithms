package 字符串;

public class _8_字符串转换整数 {
    public int myAtoi(String str) {
        if (str == null) return 0;
        char[] chars = str.toCharArray();
        int idx = 0;
        //跳过无用的前导空格
        while (idx < chars.length && chars[idx] == ' ') {
            idx++;
        }
        //整个字符串都是空格，返回0
        if (idx == chars.length) return 0;

        //默认符号为'+'
        boolean negative = false;
        //第一个字符是符号或者数字，如果不是，直接返回0
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])){
            return 0;
        }

        int ans = 0;
        //遇到不是数字或者已经读完了，返回结果
        while (idx < chars.length && Character.isDigit(chars[idx])) {
            int digital = chars[idx] - '0';
            //限制大小，这种写法可以防止超出范围，不要这么写：if（10 * ans + digital > Integer.MAX_VALUE），10 * ans可能直接越界了
            if (ans > (Integer.MAX_VALUE - digital) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digital;
            idx++;
        }
        return negative ? -ans : ans;
    }
}
