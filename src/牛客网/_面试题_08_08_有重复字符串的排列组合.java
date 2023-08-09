package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 */
public class _面试题_08_08_有重复字符串的排列组合 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abb")));
    }
   static public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        /*s的字符数组*/
        char[] arr = S.toCharArray();
        backtrack(arr, 0, list);
        return list.toArray(new String[list.size()]);
    }

    static private void backtrack(char[] arr, int idx, List<String> list) {
        if (idx == arr.length - 1) {
            list.add(new String(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = idx; i < arr.length; ++i) {
            /*set去重*/
            if (!set.add(arr[i])) {
                continue;
            }
            /*交换i和idx的值*/
            char tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
            /*进入下一层*/
            backtrack(arr, idx + 1, list);
            /*回溯：将i和idx的值互换回来*/
            tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
    }
}
