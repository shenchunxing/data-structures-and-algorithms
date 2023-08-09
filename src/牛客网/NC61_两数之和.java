package 牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 *
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 */
public class NC61_两数之和 {
    public static void main(String[] args) throws IOException {
        System.out.println(twoSum(new int[]{3,2,4},6));
    }

    public static int[] twoSum (int[] numbers, int target) {
        if (numbers.length == 0 || numbers == null) return new int[]{0,0};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer index = map.get(target - numbers[i]);
            /*可以找到下标，说明符合条件,下标从1开始算*/
            if (index !=  null) return new int[] {index + 1 , i + 1};
            /*不符合就记录值和位置*/
            map.put(numbers[i],i);
        }
        return new int[]{0,0};
    }
}
