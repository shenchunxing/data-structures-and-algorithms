package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 单词接龙的规则是：
 *
 * 可用于接龙的单词首字母必须要前一个单词的尾字母相同；
 * 当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词；已经参与接龙的单词不能重复使用。
 * 现给定一组全部由小写字母组成单词数组，并指定其中的一个单词作为起始单词，进行单词接龙，
 * 请输出最长的单词串，单词串是单词拼接而成，中间没有空格。
 * 输入描述:
 *
 * 输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N ；
 * 输入的第二行为一个非负整数，表示单词的个数N；
 * 接下来的N行，分别表示单词数组中的单词。
 * 输出描述:
 *
 * 输出一个字符串，表示最终拼接的单词串。
 */
public class 单词接龙 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*单词的起始位置*/
        int k = Integer.parseInt(scanner.nextLine());
        /*个数*/
        int n = Integer.parseInt(scanner.nextLine());
        List<String> obj = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String point = "";
        for (int i = 0; i < n; i++) {
            if (i == k) {
                /*获取起始位置的单词*/
                String content = scanner.nextLine();
                sb.append(content);
                /*point指向起始单词结尾最后的一个字符*/
                point = content.substring(content.length() - 1);
                continue;
            }
            /*其他单词正常添加*/
            obj.add(scanner.nextLine());
        }
        int flag = 0;
        while (true) {
            TreeSet<String> set = new TreeSet();
            /*如果以结尾字符开始的单词，先添加到数组*/
            for (String s : obj) {
                if (s.startsWith(point)) {
                    set.add(s);
                }
            }
            /*如果集合为空，直接退出*/
            if (set.size() == 0) {
                System.out.print(sb);
                break;
            }
            /*因为后续会删除已经操作过的单词，所以point需要重新指向下一个单词的结尾字符*/
            point = set.first().substring(set.first().length() - 1);
            String content = set.first();
            flag = Objects.requireNonNull(set.pollFirst()).length();
            /*找出长度最长的单词：dword*/
            for (String str : set) {
                if (flag < str.length()) {
                    flag = str.length();
                    point = str.substring(str.length() - 1);
                    content = str;
                }
            }
            /*删除已经操作过的单词*/
            obj.remove(content);
            /*拼接结果*/
            sb.append(content);
        }
    }
}

