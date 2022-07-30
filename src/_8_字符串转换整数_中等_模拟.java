public class _8_字符串转换整数_中等_模拟 {
    public int myAtoi(String str) {
        if (str == null) return 0;
        char[] chars = str.toCharArray();
        int idx = 0;
        while (idx < chars.length && chars[idx] == ' ') {
            idx++;
        }
        if (idx == chars.length) return 0;

        boolean negative = false;
        //第一个字符是符号位
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])){
            return 0;
        }

        int ans = 0;
        //遇到不是数字,就返回结果
        while (idx < chars.length && Character.isDigit(chars[idx])) {
            int digital = chars[idx] - '0';
            //防止越界
            if (ans > (Integer.MAX_VALUE - digital) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digital;
            idx++;
        }
        return negative ? -ans : ans;
    }
}
