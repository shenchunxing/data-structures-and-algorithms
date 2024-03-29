package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/course-schedule-ii/
 */
public class _210_课程表II {
    public static void main(String[] args) {
        _210_课程表II o = new _210_课程表II();
        System.out.println(o.findOrder(6,new int[][] {{2,1},{3,2},{4,2},{5,4},{5,3},{4,1}}));
    }

    /**
     * dfs判断图是否有环
     * numCourses:节点
     * prerequisites:边
     * O(m + n) O(m + n)
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
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
            if (!dfs(adjacency,flags,i,result)) {
                return new int[0];
            }
        }

        //反向遍历
        int[] res = new int[numCourses];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(result.size() - 1 - i);
        }
        return res;
    }

    /**
     * 从i位置，开始遍历整个图，判断是否存在环
     */
    private boolean dfs(List<List<Integer>> adjacency , int[] flags , int i, List<Integer> result) {
        if (flags[i] == 1) return false; //本轮第二次访问了，说明有环
        if (flags[i] == -1) return true; //当前节点被其他节点访问到了，不需要重复搜素
        flags[i] = 1;//当前访问了该节点
        for (Integer j : adjacency.get(i)) { //遍历当前节点的所有邻接节点
            if (!dfs(adjacency,flags,j, result)) {
                return false;
            }
        }
        flags[i] = -1;//遍历完当前节点的所有邻接节点，没有环。flags[i] = -1，返回true
        result.add(i);
        return true;
    }
}
