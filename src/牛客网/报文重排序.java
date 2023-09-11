package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入描述
 *
 * 输入第一行为N，表示子报文的个数，0 < N <= 1000。
 * 输入第二行为N个子报文，以空格分开，子报文格式为字符串报文内容+后缀顺序索引，字符串报文内容由[a-z,A-Z]组成，后缀为整形值，表示顺序。顺序值唯一，不重复。
 *
 * 输出描述
 *
 * 输出恢复出的原始报文。按照每个子报文的顺序的升序排序恢复出原始报文，顺序后缀需要从恢复出的报文中删除掉
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 4
 * rolling3 stone4 like1 a2
 * 输出
 *
 * like a rolling stone
 */
public class 报文重排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");
        List<Word> letterList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            //防止空格
            if (str.equals("")) {
                continue;
            }
            //数字开始的下标
            int index = 0;
            for (int j = 0; j < str.length(); j++) {
                if (Character.isDigit(str.charAt(j))) {
                    index = j;
                    break;
                }
            }
            //字母部分
            String letter = str.substring(0, index);
            //顺序部分
            int num = Integer.parseInt(str.substring(index));
            Word word = new Word(letter, num);
            letterList.add(word);
        }
        /*排序*/
        letterList.sort((a, b) -> {
            return a.num - b.num;
        });
        String res = "";
        for (Word word : letterList) {
            res += word.letter + " ";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
    static class Word {
        String letter;
        int num;
        public Word(String letter, int num) {
            this.letter = letter;
            this.num = num;
        }
    }
}
