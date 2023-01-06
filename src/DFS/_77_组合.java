package DFS;

import java.util.*;

/**
 * https://leetcode.cn/problems/combinations/
 */
public class _77_组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        if (k < 0 || k > n) return ans;
        dfs(n , k ,1, ans, path);
        return ans;
    }

    private void dfs(int n , int k ,int begin , List<List<Integer>> ans,Deque<Integer> path) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(n, k , i + 1,ans,path);
            path.removeLast();
        }
    }
}
