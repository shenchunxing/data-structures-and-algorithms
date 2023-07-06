package DFS;

import java.util.*;

/**
 * https://leetcode.cn/problems/combinations/
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
/*2023-7-6*/
public class _77_组合 {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    static public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        if (k < 0 || k > n) return ans;
        dfs(n , k ,1, ans, path);
        return ans;
    }

    static private void dfs(int n , int k ,int begin , List<List<Integer>> ans,Deque<Integer> path) {
        /*已经选好k个数，返回一个答案*/
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        /*循环遍历从begin开始，防止重复，for循环代表这次循环可以选择的数*/
        for (int i = begin; i <= n; i++) {
            path.add(i);
            /*进入下一层，begin + 1，可以选择的数会减少一个*/
            dfs(n, k , i + 1,ans,path);
            /*移除上次选中的数*/
            path.removeLast();
        }
    }
}
