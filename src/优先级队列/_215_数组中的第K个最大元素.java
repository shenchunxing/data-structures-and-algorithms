package 优先级队列;

import java.util.PriorityQueue;

public class _215_数组中的第K个最大元素 {
    //优先级队列 O(NlogK)
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 ) return  0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();//优先级队列，构建小顶堆
        for (int n : nums) {
            heap.add(n);
            //保持小顶堆大小 ： 堆大小是k，堆顶是第k小的元素，堆顶下的元素都比堆顶要大
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //堆顶
        return heap.peek();
    }
}
