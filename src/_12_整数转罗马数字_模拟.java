/**
 * https://leetcode.cn/problems/integer-to-roman/
 */
public class _12_整数转罗马数字_模拟 {
    public static void main(String[] args) {
        _12_整数转罗马数字_模拟 o = new _12_整数转罗马数字_模拟();
        System.out.println(o.intToRoman(1401));
    }

    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    //枚举法
    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}
