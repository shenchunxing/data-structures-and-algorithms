package 哈希表;

import java.util.HashMap;

public class _166_分数到小数 {
    public static void main(String[] args) {
//        System.out.println(fractionToDecimal(1,2));
//        System.out.println(fractionToDecimal(2,-1));
//        System.out.println(fractionToDecimal(1,3));
        System.out.println(fractionToDecimal(3,4));
    }
       static public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";
            StringBuilder builder = new StringBuilder();
            if (numerator <0 ^ denominator <0) { //如果被除数和除数其中一个是负数
                builder.append("-");
            }
            //转成long类型的正数
            long dividend = Math.abs(Long.valueOf(numerator));
            long divisor = Math.abs(Long.valueOf(denominator));
            //拼接整除结果
            builder.append(String.valueOf(dividend / divisor));
            long remainder = dividend % divisor ; //获取余数
            //可以整除，直接返回
            if (remainder == 0) return builder.toString() ;
            //余数不为0，说明存在小数
            builder.append(".");

            //哈希表保存余数出现在小数的位置
            HashMap<Long,Integer> map = new HashMap<>();

            //循环判断是否结束，如果发现remainder重复出现，出现了循环小数
           //remainder = 0 ： 可以除尽，返回结果
            while (remainder != 0) {
                //说明是循环小数，举例2 / 3 = 0.66666
                if (map.containsKey(remainder)) {
                    builder.insert(map.get(remainder),"(");
                    builder.append(")");
                    break;
                }

                //举例：3 / 4 = 0.75
                map.put(remainder,builder.length());
                remainder *= 10;
                builder.append(String.valueOf(remainder / divisor));
                remainder %= divisor;
            }
            return builder.toString();
        }
}
