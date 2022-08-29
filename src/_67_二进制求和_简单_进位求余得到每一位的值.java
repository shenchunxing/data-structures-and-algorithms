/**
 * https://leetcode.cn/problems/add-binary/
 */
public class _67_二进制求和_简单_进位求余得到每一位的值 {
    public static void main(String[] args) {
        _67_二进制求和_简单_进位求余得到每一位的值 ob  = new _67_二进制求和_简单_进位求余得到每一位的值();
        System.out.println(ob.addBinary("1010","1011"));
    }
    //整体思路是将两个字符串较短的用0 补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int ca = 0;//进位
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 ; i-- ,j --) {
            int sum = ca;//默认值是上次的进位
            sum += i >= 0 ? a.charAt(i) - '0' : 0; //不足就补0
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            builder.append(sum % 2); //求和
            ca = sum / 2; //查看是否有进位
        }
        builder.append(ca == 1 ? ca : "");
        //二进制结果需要翻转
        return builder.reverse().toString();
    }
}
