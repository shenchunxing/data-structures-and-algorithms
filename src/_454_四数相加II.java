import java.util.HashMap;

/**
 * https://leetcode.cn/problems/4sum-ii/
 */
public class _454_四数相加II {
    public static void main(String[] args) {
        System.out.println(fourSumCount(
                new int[] {1,2},new int[] {-2,-1},new int[] {-1,2},new int[] {0,2})
        );
    }

    static public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();

        //记录前2个数组的正数和，以及出现的次数
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }

        int count = 0;
        //记录后2个数组的负数和，以及出现的次数
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = -nums3[i] - nums4[j];
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }
}
