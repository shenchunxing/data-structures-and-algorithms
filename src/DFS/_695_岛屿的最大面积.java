package DFS;

/**
 * https://leetcode.cn/problems/max-area-of-island/
 * 难度：中等
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
/*2023-7-11*/
public class _695_岛屿的最大面积 {
    static public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //如果是陆地，则去上下左右4个方向去深度搜索，发现更多陆地
                if (grid[i][j] == 1) {
                    /*最大岛屿*/
                    res = Math.max(res,dfs(i , j, grid));
                }
            }
        }
        return res;
    }

    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
    // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
    static private int dfs(int i ,int j , int[][]grid) {
        //边界条件：达到了数组的边界，或者 遇到了水
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;//已经到达过该岛屿，用水覆盖
        int num = 1;//默认岛屿面积是1，从[i,j]的位置向四周扩散，期望找到更大的陆地
        num += dfs(i + 1,j , grid);
        num += dfs(i,j + 1 , grid);
        num += dfs(i,j - 1 , grid);
        num += dfs(i - 1,j , grid);
        return num;
    }
}
