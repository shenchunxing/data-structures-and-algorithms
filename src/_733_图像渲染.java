import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/flood-fill/
 */
public class _733_图像渲染 {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};

    //dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sc < 0 || sr < 0 || sr >= image.length || sc >= image[0].length
        || image[sr][sc] != oldColor || newColor == oldColor) {
            return;
        }

        image[sr][sc] = newColor;//上色
        //四个方向去上色
        dfs(image,sr - 1,sc,newColor,oldColor);
        dfs(image,sr,sc - 1,newColor,oldColor);
        dfs(image,sr,sc + 1,newColor,oldColor);
        dfs(image,sr + 1,sc,newColor,oldColor);
    }

    /**
     * O(m*n) O(m*n)
     * bfs
     * @param image
     * @param sr：
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
