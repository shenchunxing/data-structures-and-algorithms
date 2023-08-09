package 牛客网;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/1
 */
public class _994_腐烂的橘子 {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
    static public int orangesRotting(int[][] grid) {
        /*表示移动的方向：上左下右*/
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        /*行和列*/
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                /*发现了腐烂橘子*/
                if (grid[r][c] == 2) {
                    /*拿到在一维数组中的编码*/
                    int code = r * C + c;
                    /*入队*/
                    queue.add(code);
                    /*存储每个腐烂橘子的深度，默认是0*/
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        /*开始BFS循环，直到队列为空，即所有腐烂橘子和相应的新腐烂橘子都已被处理*/
        while (!queue.isEmpty()) {
            /*要处理的橘子*/
            int code = queue.remove();
            /*获取其行列位置*/
            int r = code / C, c = code % C;
            /*在当前位置的上下左右4个方向遍历*/
            for (int k = 0; k < 4; ++k) {
                /*得到相邻位置的行列*/
                int nr = r + dr[k];
                int nc = c + dc[k];
                /*行列在范围内，且如果是新鲜橘子，就变成腐烂橘子*/
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    /*获取位置*/
                    int ncode = nr * C + nc;
                    /*入队*/
                    queue.add(ncode);
                    /*给当前从新鲜到腐烂的橘子，深度+1*/
                    depth.put(ncode, depth.get(code) + 1);
                    /*获取当前橘子的深度*/
                    ans = depth.get(ncode);
                }
            }
        }
        /*遍历每一行，如果还发现有新鲜橘子，返回-1*/
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        /*没有新鲜橘子，说明全部变腐烂了*/
        return ans;
    }
}
