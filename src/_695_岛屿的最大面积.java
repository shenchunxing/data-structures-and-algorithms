/**
 * https://leetcode.cn/problems/max-area-of-island/
 */
public class _695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //如果是岛屿，则去上下左右4个方向去深度搜索
                if (grid[i][j] == 1) {
                    res = Math.max(res,dfs(i , j, grid));
                }
            }
        }
        return res;
    }

    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
    // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
    private int dfs(int i ,int j , int[][]grid) {
        //边界条件：达到了数组的边界，或者 grid[i][j] == 0 。搜索到的岛屿
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;//已经到达过该岛屿
        int num = 1;//默认是1
        num += dfs(i + 1,j , grid);
        num += dfs(i,j + 1 , grid);
        num += dfs(i,j - 1 , grid);
        num += dfs(i - 1,j , grid);
        return num;
    }
}
