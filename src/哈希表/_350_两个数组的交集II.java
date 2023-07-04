package 哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 */
/*2023-7-4*/
public class _350_两个数组的交集II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect2(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(intersect2(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }

    /**
     * 哈希表
     */
    static public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();
        for (int num : nums1) {  //统计num1中的所有数字出现的次数
            int count = map.getOrDefault(num, 0 ) + 1;
            map.put(num,count);
        }
        //创建长度较小的数组，默认都是0，可能存在多余的0需要去除
        int[] ans = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
        for (int num : nums2) {
            //获取当前的num出现的次数
            int count = map.getOrDefault(num, 0);
            if (count > 0) { //如果在num2中也找到了相同的数
                ans[index] = num; //加入答案
                index++;//位置移动一位
                /*这里是因为可能存在重复的元素，出现一次就要减去一次，同时更新数量*/
                count--;
                map.put(num,count);
            }
        }
        //去掉无用的'0'
        return Arrays.copyOfRange(ans, 0 ,index);
    }

    /**
     * 排序+双指针
     */
   static public int[] intersect(int[] nums1, int[] nums2) {
       /*首先进行排序*/
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length , length2 = nums2.length;
        int index1 = 0 , index2 = 0 , index = 0;
        /*数组大小默认是两个数组长度的较小值，最后还需要去掉默认的0而缩小数组大小*/
        int[] ans = new int[Math.min(length1,length2)];
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                /*两者相等，说明存在交集了，添加到结果中，同时指针++*/
                ans[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        //去掉无用的'0'
        return Arrays.copyOfRange(ans, 0 ,index);
    }
}
