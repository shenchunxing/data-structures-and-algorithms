import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class 剑指Offer56_II_数组中数字出现的次数II {
    //O(n) O(1):常数大小32
    //不理解
    public int singleNumber(int[] nums) {
        //记录每个num的二进制1的个数
        int[] counts = new int[32];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 32; j++) {
                counts[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1; //左移一位
            res |= counts[31 - i] % m; //恢复第i位的值
        }
        return res;
    }

    //哈希表:O(n) O(n)
    public int singleNumber2(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for (int x : nums) {
            map.put(x,map.containsKey(x)); //只有一次的数字，会是false
        }
        for (int x : nums) {
            if (!map.get(x)) return x; //找出那个为false的就行
        }
        return -1;
    }
}
