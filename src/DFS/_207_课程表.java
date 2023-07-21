package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/course-schedule/
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 *
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 深度优先搜索、广度优先搜索
 * */
public class _207_课程表 {
    public static void main(String[] args) {
        _207_课程表 o = new _207_课程表();
        System.out.println(o.canFinish(6,new int[][] {{2,1},{3,2},{4,2},{5,4},{5,3},{4,1}}));
    }
    /**
     * dfs判断图是否有环
     * numCourses:节点
     * prerequisites:边
     * O(m + n) O(m + n)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) { //新建空的list
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses]; //记录访问的节点情况：0表示还未访问，1表示当前访问了，-1表示其他节点访问的时候访问了此节点
        for (int[] cp : prerequisites) {
            List<Integer> cur = adjacency.get(cp[1]);
            cur.add(cp[0]); // 保存节点cp[1]的所有邻接节点（可以到达的节点）
        }
        //对每个节点dfs，发现有环直接返回
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency,flags,i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从i位置，开始遍历整个图，判断是否存在环
     */
    private boolean dfs(List<List<Integer>> adjacency , int[] flags , int i) {
        if (flags[i] == 1) return false; //本轮第二次访问了，说明有环
        if (flags[i] == -1) return true; //当前节点被其他节点访问到了，不需要重复搜素
        flags[i] = 1;//当前访问了该节点
        for (Integer j : adjacency.get(i)) { //遍历当前节点的所有邻接节点
            if (!dfs(adjacency,flags,j)) {
                return false;
            }
        }
        flags[i] = -1;//遍历完当前节点的所有邻接节点，没有环。flags[i] = -1，返回true
        return true;
    }


}
