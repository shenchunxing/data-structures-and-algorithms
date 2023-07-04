package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
/*2023-7-4*/
public class _17_电话号码的字母组合 {
    static char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        String digits1 = "23";
        List<String> result1 = letterCombinations(digits1);
        System.out.println("Letter combinations for digits " + digits1 + ":");
        System.out.println(result1);
    }

    static public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null) return list;
        char[] chars = digits.toCharArray();
        if (chars.length == 0) return list;
        char[] string = new char[chars.length];//存储答案的字符数组，转换成string，添加到list中
        dfs(list,lettersArray,0,chars,string);
        return list;
    }

    static private void dfs(List<String> list,  char[][] lettersArray, int index, char[] chars ,char[] string) {
        /*递归出口，已经扫描到了最后一层*/
        if (index == chars.length) {
            list.add(new String(string));
            return;
        }
        char[] letters = lettersArray[chars[index] - '2']; //这一层的所有可选字母
        for (char c : letters) {
            string[index] = c;//选择一个字符
            dfs(list,lettersArray,index + 1,chars,string);//进入下一层
        }
    }
}
