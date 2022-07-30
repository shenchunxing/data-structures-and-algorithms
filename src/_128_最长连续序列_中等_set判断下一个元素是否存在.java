import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列_中等_set判断下一个元素是否存在 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        //遍历每个元素，查看当前元素的前一个元素和后一个元素是否存在
        for (int num : set) {
            //如果不包含前一个数字，说明从当前num开始是最长的起始位置
            if (!set.contains(num - 1)) {
                int currentNum = num;//指向当前值的指针
                int currentStreak = 1;//统计当前num下的最长连续序列长度
                //循环判断是否包含currentNum+1，如果包含则currentStreak+1，当前值指针指向currentNum+1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak ,currentStreak);
            }
        }

        return longestStreak ;
    }
}
