package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * C 语言有一个库函数：char *strstr(const char *haystack, const char *needle) ，实现在字符串haystack中查找第一次出现字符串needle的位置，如果未找到则返回 null。
 *
 * 现要求实现一个strstr的增强函数，可以使用带可选段的字符串来模糊查询，与strstr一样返回首次查找到的字符串位置。
 *
 * 可选段使用“[]”标识，表示该位置是可选段中任意一个字符即可满足匹配条件。比如“a[bc]”表示可以匹配“ab”或“ac”。
 *
 * 注意目标字符串中可选段可能出现多次。
 * 输入描述
 *
 * 与strstr函数一样，输入参数是两个字符串指针，分别是源字符串和目标字符串。
 *
 * 输出描述
 *
 * 与strstr函数不同，返回的是源字符串中，匹配子字符串相对于源字符串地址的偏移（从0开始算），如果没有匹配返回-1。
 * 补充说明：源字符串中必定不包含‘[]’；目标字符串中‘[]’必定成对出现，且不会出现嵌套。
 * 输入的字符串长度在[1,100]之间。
 */
public class 增强的strstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yuan = sc.nextLine();
        String mubiao = sc.nextLine();
        List<String> mubiaoList = new ArrayList<>();
        String temp = "";
        //是否在中括号里面
        boolean isKuohao = false;
        /*该循环是为了分离精确匹配和可选匹配的字符*/
        for (int i = 0; i < mubiao.length(); i++) {
            char c = mubiao.charAt(i);
            if ((c == '[' || c == ']')) {
                if (!temp.equals("")) {
                    mubiaoList.add(temp);
                    temp = "";
                }
                /*在中括号里面的字母*/
                isKuohao = !isKuohao;
            } else if (isKuohao) {
                //在中括号里面的则进行拼接（模糊查询）
                temp += c;
            } else {
                //不在中括号里面的需要精确匹配
                mubiaoList.add(String.valueOf(c));
            }
        }
        int res = -1;
        for (int i = 0; i < yuan.length(); i++) {
            String s = String.valueOf(yuan.charAt(i));
            //是否能够匹配
            boolean isMatch = true;
            //第一个字符对应上了
            if (s.equals(mubiaoList.get(0))) {
                //源字符串的索引
                int index = i + 1;
                //遍历目标字符串
                for (int j = 1; j < mubiaoList.size(); j++) {
                    String str = mubiaoList.get(j);
                    if (index < yuan.length() && str.contains(String.valueOf(yuan.charAt(index)))) {
                        //源字符串索引没有越界，且字符符合目标中的字符
                        index++;
                    } else {
                        isMatch = false;
                        break;
                    }
                }
                /*完全匹配*/
                if (isMatch) {
                    res = i;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
