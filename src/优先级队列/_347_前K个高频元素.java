package 优先级队列;

import com.mj.sort.cmp.HeapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
/*2023-7-4*/
public class _347_前K个高频元素 {
    public static void main(String[] args) {
        int[] arrays = new int[] {1,1,1,2,2,3};
        int[] ans = topKFrequent(arrays,2);
        System.out.println(Arrays.toString(ans));
    }
    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //统计每个数字的频率：key为数字，value为次数
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        //按出现的频率升序排列，维护一个小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        //heap存储的是key的集合，也就是num
        for (int n : map.keySet()) {
            heap.add(n);
            //只维护前K个大小
            if (heap.size() > k) {
                heap.poll();
            }
        }

        /*从heap中拿到数据转成int数组*/
        int[] ans = new int[heap.size()];
        int index = 0;
        while (!heap.isEmpty()) {
            ans[index++] = heap.poll();
        }
        return ans;
    }
}
