package 字符串;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/
 * 难度：中等
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class _8_字符串转换整数 {
    public static void main(String[] args) {
        System.out.println(myAtoi("     -42"));
        System.out.println(myAtoi("4193 with words"));
    }
    static public int myAtoi(String str) {
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
        /*第一个字符是'-'*/
        if (chars[idx] == '-') {
            negative = true;
            idx++;
            /*第一个字符是'+'*/
        } else if (chars[idx] == '+') {
            idx++;
            /*第一个字符不是数字，直接返回0*/
        } else if (!Character.isDigit(chars[idx])){
            return 0;
        }

        int ans = 0;
        //遇到不是数字或者已经读完了，返回结果
        while (idx < chars.length && Character.isDigit(chars[idx])) {
            /*转成数字*/
            int digital = chars[idx] - '0';
            //限制大小，这种写法可以防止超出范围，不要这么写：if（10 * ans + digital > Integer.MAX_VALUE），10 * ans可能直接越界了
            /*为什么这里负数也可以这么处理？因为在处理过程中就是用正数在处理，只是在return的时候才用负数区别*/
            if (ans > (Integer.MAX_VALUE - digital) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digital;
            idx++;
        }
        return negative ? -ans : ans;
    }
}
