package 牛客网;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，
 * 每个箱子上面贴有箱子中藏有金币的数量。
 * 从金币数量中选出一个数字集合，并销毁贴有这些数字的每个箱子，
 * 如果能销毁一半及以上的箱子，则返回这个数字集合的最小大小。
 *
 * 输入描述
 *
 * 一个数字字串，数字之间使用逗号分隔，例如: 6,6,6,6,3,3,3,1,1,5
 * 字串中数字的个数为偶数，并且个数>=1，<=100000；每个数字>=1，<=100000；
 *
 * 输出描述
 *
 * 这个数字集合的最小大小，例如：2
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 1,1,1,1,3,3,3,6,6,8
 * 输出
 *
 * 2
 */
public class 阿里巴巴找黄金宝箱II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        /**
         * key：数字
         * value：数字的个数
         */
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        //按照数字个数降序排序
        list.sort((a, b) -> {
            return b.getValue() - a.getValue();
        });
        //销毁的箱子个数
        int count = 0;
        //半数箱子（因为是半数及以上，所以需要向上取整）
        int half = (int) Math.ceil((double) strings.length / 2);
        //数组的长度
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            /*箱子个数积累*/
            count += list.get(i).getValue();
            res++;
            if (count >= half) {
                //已经销毁半数及以上
                break;
            }
        }
        System.out.println(res);
    }
}
