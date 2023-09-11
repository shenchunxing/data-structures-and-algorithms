package 牛客网;

import java.util.Scanner;

/**
 * 存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~128，以#号间隔，格式如下：
 * (1~128)#(0~255)#(0~255)#(0~255)
 * 请利用这个特性把虚拟IPv4地址转换为一个32位的整数，IPv4地址以字符串形式给出，要求每个IPvV4地址只能对应到唯一的整数上。
 * 如果是非法IPv4，返回invalid IP。
 *
 * 输入描述
 *
 * 输入一行，虚拟IPv4地址格式字符串
 *
 * 输出描述
 *
 * 输出一行，按照要求输出整型或者特定字符
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 100#101#1#5
 *
 * 输出
 *
 * 1684340997
 */
public class IPv4地址转换成整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split("#");
        int len = strings.length;
        long count = 0;
        /*不合法标志*/
        boolean isF = true;
        if (len == 4) {
            for (int i = 0; i < len; i++) {
                long n = Integer.parseInt(strings[i]);
                if (i == 0 && (n < 1 || n > 128)) {
                    isF = false;
                    break;
                } else if (n < 0 || n > 255) {
                    isF = false;
                    break;
                }
                /*8 * (3 - i)表示需要左移的位数*/
                count += n << (8 * (3 - i));
            }
        } else {
            isF = false;
        }
        if (isF) {
            System.out.println(count);
        } else {
            System.out.println("invalid IP");
        }
    }
}
