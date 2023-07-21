package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 难度：中等
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class _131_分割回文串 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    static public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new LinkedList<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }
    /**
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    static private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {//递归出口
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历以start为起始位置，长度为len - start的子串
        for (int i = start; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            /*[start,i]区间是一个回文串，添加到结果集*/
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.removeLast();//回溯
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，判断s的[left,right]区间的子串是否是一个回文串
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     */
    static private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
