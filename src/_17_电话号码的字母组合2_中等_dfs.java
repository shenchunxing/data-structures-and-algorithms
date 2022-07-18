import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class _17_电话号码的字母组合2_中等_dfs {
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null) return list;
        char[] chars = digits.toCharArray();
        if (chars.length == 0) return list;
        char[] string = new char[chars.length];
        dfs(list,lettersArray,0,chars,string);
        return list;
    }

    private void dfs(List<String> list,  char[][] lettersArray, int index, char[] chars ,char[] string) {
        if (index == chars.length) {
            list.add(new String(string));
            return;
        }
        char[] letters = lettersArray[chars[index] - '2']; //这一层的所有可选字母
        for (char c : letters) {
            string[index] = c;
            dfs(list,lettersArray,index + 1,chars,string);
        }
    }
}
