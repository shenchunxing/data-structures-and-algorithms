package 优先级队列;

import java.util.PriorityQueue;

/*
https://leetcode.cn/problems/kth-largest-element-in-an-array/
* */
public class _215_数组中的第K个最大元素 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4},2));
    }
    //优先级队列 O(NlogK)
    static public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 ) return  0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();//优先级队列，构建小顶堆
        for (int n : nums) {
            heap.add(n);
            //保持小顶堆大小 ： 堆大小是k，堆顶是第k小的元素，堆顶下的元素都比堆顶要大
            if (heap.size() > k) {
                /*删除后堆会自动进行重新排布，确保小顶堆特性*/
                heap.poll();
            }
        }
        //堆顶
        return heap.peek();
    }
}
