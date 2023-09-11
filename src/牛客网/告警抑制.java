package 牛客网;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 告警抑制，是指高优先级告警抑制低优先级告警的规则。高优先级告警产生后，低优先级告警不再产生。请根据原始告警列表和告警抑制关系，给出实际产生的告警列表。
 *
 * 不会出现循环抑制的情况。
 * 告警不会传递，比如A->B,B->C，这种情况下A不会直接抑制C。但被抑制的告警仍然可以抑制其他低优先级告警
 *
 * 输入描述
 *
 * 第一行为数字N，表示告警抑制关系个数，0 ≤ N ≤ 120
 * 接下来N行，每行是由空格分隔的两个告警ID，例如: id1 id2，表示id1抑制id2，告警ID的格式为：
 *
 * 大写字母+0个或者1个数字
 *
 * 最后一行为告警产生列表，列表长度[1,100]
 *
 * 输出描述
 *
 * 真实产生的告警列表
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 2
 * A B
 * B C
 * A B C D E
 * 输出
 *
 * A D E
 */
public class 告警抑制 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, HashSet<String>> fa = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            // id1抑制id2
            String id1 = tmp[0], id2 = tmp[1];
            fa.putIfAbsent(id2, new HashSet<>());
            // fa用于记录抑制id2的所有id1的集合
            fa.get(id2).add(id1);
        }
        /*告警列表*/
        String[] alertList = sc.nextLine().split(" ");
        System.out.println(getResult(fa, alertList));
    }

    public static String getResult(HashMap<String, HashSet<String>> fa, String[] alertList) {
        HashSet<String> alertSet = new HashSet<>(Arrays.asList(alertList));
        /*StringJoiner用间隔符拼接add后的元素*/
        StringJoiner sj = new StringJoiner(" ");
        for (String id2 : alertList) {
            // 如果没有抑制id2的更高级的告警，或者有抑制id2的更高级的告警，但是此高级告警没有出现在alertList列表中
            /*disjoint是求集合是否没有公共元素*/
            if (!fa.containsKey(id2) || Collections.disjoint(fa.get(id2), alertSet)) {
                // 此时id2就可以正常告警
                sj.add(id2);
            }
        }
        return sj.toString();
    }
}
