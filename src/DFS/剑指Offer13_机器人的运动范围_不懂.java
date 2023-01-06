package DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class 剑指Offer13_机器人的运动范围_不懂 {
    int m, n, k;
    boolean[][] visited;

    //递推：搜索方向只需要朝右或者朝下
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        boolean[][] visited = new boolean[m][n]; //表示[i][j]是否可达
        int ans = 1;//默认1
        visited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue; //第0行0列，过滤
                if (get(i) + get(j) > k) continue; //根据题意的提示，大于k是不可达的，直接过滤
                if (i - 1 >= 0) visited[i][j] |= visited[i - 1][j];//从[i - 1][j]来，
                if (j - 1 >= 0) visited[i][j] |= visited[i][j - 1];//从[i][j - 1]来
                ans += visited[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    //n每一位相加
    private int get(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public int movingCount1(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || si + sj > k || visited[i][j]) return 0;
        visited[i][j] = true;
        //si:横轴方向的位数和 sj：纵轴方向的位数和
        //si = (i + 1) % 10 != 0 ? si + 1 : si - 8
        //总数 = 1 + 横轴的和 + 纵轴方向的和
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    //bfs
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
}
