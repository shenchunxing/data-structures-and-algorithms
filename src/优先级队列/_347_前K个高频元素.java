package 优先级队列;

import com.mj.sort.cmp.HeapSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //统计每个数字的频率
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        //按出现的频率从大到小排列
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        //heap存储的是key的集合
        for (int n : map.keySet()) {
            heap.add(n);
            //只维护前K个大小
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> list = new LinkedList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        //list转int数组
        return list.stream().mapToInt(
                Integer::valueOf
        ).toArray();
    }
}
