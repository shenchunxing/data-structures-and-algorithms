package 排序指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 */
/*2023-7-14 会员题*/
public class _252_会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 遍历每一个会议
        for (int i = 1; i < intervals.length; i++) {
            /*下一个会议的开始时间 < 当前会议的结束时间,说明冲突了。*/
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        
        return true;
    }
}
