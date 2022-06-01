/**
 * https://leetcode.cn/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式
 */
public class _43_字符串相乘 {
    public static void main(String[] args) {
        _43_字符串相乘 ob = new _43_字符串相乘();
        System.out.println(ob.multiply("1234","567"));
    }
    /**
     * 做竖式乘法：num1 * num2的最大位数就是两者的长度相加，可以创建一个数组来存储每一次的结果
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        //竖式乘法，从最后位开始计算
        for (int i = m - 1; i >= 0 ; i--) {
            int x = num1.charAt(i) - '0'; //转成数字
            for (int j = n - 1; j >=0 ; j--) {
                int y = num2.charAt(j) - '0';//转成数字
                int sum = ansArr[i + j + 1] + x * y;
                ansArr[i + j + 1] = sum % 10; //当前位
                ansArr[i + j] += sum / 10; //进位需要和下一次的值合并
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ansArr.length; i++) {
            if (i == 0 && ansArr[i] == 0) continue; //最高位如果是0，则舍弃
            builder.append(ansArr[i]);
        }
        return builder.toString();
    }
}
