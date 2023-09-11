package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 通常使用多行的节点、父节点表示一棵树，比如
 * 西安 陕西
 * 陕西 中国
 * 江西 中国
 * 中国 亚洲
 * 泰国 亚洲
 * 输入一个节点之后，请打印出来树中他的所有下层节点。
 * 输入描述
 *
 * 第一行输入行数，下面是多行数据，每行以空格区分节点和父节点
 * 接着是查询节点
 *
 * 输出描述
 *
 * 输出查询节点的所有下层节点。以字典序排序
 */
public class 树状结构查询 {
    public static Set<String> set = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            list.add(strings);
        }
        /*需要查询的节点*/
        String check = sc.nextLine();
        handle(list, check);
        for (String s : set) {
            System.out.println(s);
        }
    }
    /**
     * @param list   树集合
     * @param father 父节点
     */
    public static void handle(List<String[]> list, String father) {
        for (int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i);
            /*父节点相同，拿到子节点。然后以子节点为父节点，继续查询子节点*/
            if (strings[1].equals(father)) {
                set.add(strings[0]);
                handle(list, strings[0]);
            }
        }
    }
}
