import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 */
public class _77_组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || n < k) return res;
        Deque<Integer> path = new LinkedList<>();
        dfs( n , k , 1,path,res); //题目要求范围是从1开始
        return res;
    }

    private void dfs(int n ,int k , int begin , Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) { //得到一个解
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin ; i <= n ;i++) {
            path.add(i);//向路径中添加一个数
            dfs(n , k , i + 1,path,res); //进入下一层
            path.removeLast(); //回溯
        }
    }
}
