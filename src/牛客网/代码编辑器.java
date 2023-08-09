package 牛客网;

import java.util.Scanner;

/**
 * 某公司为了更高效的编写代码, 邀请你开发一款代码编辑器程序。
 *
 * 程序的输入为已有的代码文本和指令序列，程序需输出编辑后的最终文本。指针初始位置位于文本的开头。
 *
 * 支持的指令(X为大于等于0的整数, word 为无空格的字符串)：
 *
 * # FORWARD X 指针向前(右)移动X, 如果指针移动位置超过了文本末尾，则将指针移动到文本末尾
 * # BACKWARD X 指针向后(左)移动X,如果指针移动位置超过了文本开头，则将指针移动到文本开头
 *
 * # SEARCH-FORWARD word 从指针当前位置向前查找 word 并将指针移动到word的起始位置，如果未找到则保持不变
 *
 * SEARCH-BACKWARD word 在文本中向后查找 word 并将指针移动到word的起始位置，如果未找到则保持不变
 * INSERT word 在指针当前位置前插入word，并将指针移动到word的结尾
 *
 * REPLACE word 在指针当前位置替换并插入字符（删除原有字符，并增加新的字符）
 *
 * # DELETE X 在指针位置删除X个字符
 *
 * 输入描述
 *
 * 输入的第一行为命令列表的长度K
 * 输入的第二行为文件中的原始文本
 * 接下来的K行，每行为一个指令
 *
 * 输出描述
 *
 * 编辑后的最终结果
 * 补充说明：
 *
 * 文本最长长度不超过 256K
 */
public class 代码编辑器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*有K个命令需要执行*/
        int K = sc.nextInt();
        sc.nextLine();
        /*原始单词*/
        String code = sc.nextLine();
        //光标（当前位置）
        int index = 0;
        int X, len;
        for (int i = 0; i < K; i++) {
            String[] actions = sc.nextLine().split(" ");
            //操作
            String action = actions[0];
            //操作内容
            String word = actions[1];
            switch (action) {
                case "FORWARD":
                    X = Integer.valueOf(word);
                    //光标最远不能超过编码长度
                    index = Math.min(index + X, code.length());
                    break;
                case "BACKWARD":
                    X = Integer.valueOf(word);
                    //光变最前不能超过0
                    index = Math.max(index - X, 0);
                    break;
                case "SEARCH-FORWARD":
                    index = searchForward(index, word, code);
                    break;
                    /*SEARCH-BACKWARD word 在文本中向后查找 word 并将指针移动到word的起始位置，如果未找到则保持不变*/
                case "SEARCH-BACKWARD":
                    index = searchBackward(index, word, code);
                    break;
                    /*INSERT word 在指针当前位置前插入word，并将指针移动到word的结尾*/
                case "INSERT":
                    len = word.length();
                    code = code.substring(0, index) + word + code.substring(index);
                    index += len;
                    break;
                case "REPLACE":
                    len = word.length();
                    if (index + len > code.length()) {
                        //替换超过了代码长度，则后面的不要了
                        code = code.substring(0, index) + word;
                    } else {
                        code = code.substring(0, index) + word + code.substring(index + len);
                    }
                    //光标移到word尾
                    index += len;
                    break;
                    /*DELETE X 在指针位置删除X个字符*/
                case "DELETE":
                    X = Integer.valueOf(word);
                    if (index + X > code.length()) {
                        //删除超过代码长度，则后面的不要了
                        code = code.substring(0, index);
                    } else {
                        code = code.substring(0, index) + code.substring(index + X);
                    }
            }
        }
        System.out.println(code);
    }
    public static int searchForward(int index, String word, String code) {
        //查找的字符长度
        int len = word.length();
        for (int i = index; i >= len; i--) {
            //根据查找字符的长度进行字符串截取
            String string = code.substring(i - len, i);
            if (word.equals(string)) {
                //找到第一个符合的字符返回其起始位置
                return i - len;
            }
        }
        return index;
    }
    /*在code中查找word的位置，从index向后查找*/
    public static int searchBackward(int index, String word, String code) {
        //查找的字符长度
        int len = word.length();
        for (int i = index; i <= code.length() - len; i++) {
            //根据查找字符的长度进行字符串截取
            String string = code.substring(i, i + len);
            if (word.equals(string)) {
                //找到第一个符合的字符返回其起始位置
                return i;
            }
        }
        return index;
    }
}
