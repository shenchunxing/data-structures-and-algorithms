package 排序指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 * 难度：中等
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class _56_合并区间 {
    public static void main(String[] args) {
        int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }
    //O(nlogn) O(logn)
    static public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        //按照起始时间升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>(); //{1,3},{2,6},{8,10},{15,18}
        for (int i = 0; i < intervals.length; i++) {
            //当前遍历的时段的开始值和结束值
            int start = intervals[i][0] , end = intervals[i][1];
            //如果数组是空的， 或者 起始时间的最大的时段的结束时间小于时段的开始时间，则需要新增
            if (merged.size() ==0 || merged.get(merged.size() - 1)[1] < start) {
                merged.add(new int[]{start,end});
            } else {
                //较大值作为结束时间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],end);
            }
        }
        //list 转 array
        return merged.toArray(new int[merged.size()][]);
    }
}
