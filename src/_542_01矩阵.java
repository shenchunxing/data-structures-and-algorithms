import common.TreeNode;

/**
 * https://leetcode.cn/problems/01-matrix/
 */
public class _542_01矩阵 {
    private int min ;
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null) return mat;
        //标记数组是否访问过
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) { //计算距离，默认距离是0
                    int count = 0;
                    min = Integer.MAX_VALUE;
                    dfs(mat,i,j,count,visited);
                    mat[i][j] = min; //得到对应的最小值
                }
            }
        }
        return mat;
    }

    private void dfs(int[][] mat , int i , int j , int count, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || visited[i][j]) {
            return;
        }

        if (count > min) return;//直接剪枝
        if (mat[i][j] == 0) { //访问到了0，得到了一个解
            min = Math.min(min,count);
            return;
        }
        visited[i][j] = true;//该位置已经被访问过了

        //四个方向去访问
        dfs(mat,i + 1, j,count + 1,visited);
        dfs(mat,i, j + 1,count + 1,visited);
        dfs(mat,i - 1, j,count + 1,visited);
        dfs(mat,i, j - 1,count + 1,visited);
        //回溯
        visited[i][j] = false;
    }
}
