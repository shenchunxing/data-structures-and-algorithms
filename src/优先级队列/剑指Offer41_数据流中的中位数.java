package 优先级队列;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
public class 剑指Offer41_数据流中的中位数 {
    //方法一：排序，
    //方法二：堆
    public class MedianFinder {
        Queue<Integer> queueA,queueB;
        /** initialize your data structure here. */
        public MedianFinder() {
            queueA = new PriorityQueue<>(); //小顶堆,保存较大的一半数据
            queueB = new PriorityQueue<>((x , y) -> (y - x));//大顶堆，保存较小的一半数据
        }

        public void addNum(int num) {
          //5 2 4 3 1 6
            //优先小顶堆，为了维护堆的性质和大顶堆放较小的数，小顶堆放较大的数，每次先添加到堆里，再poll出来
            if (queueA.size() !=  queueB.size())  { //n为奇数，这时a的大小是（n + 1） / 2,b的大小是（n - 1） / 2
                queueA.add(num);
                queueB.add(queueA.poll());
            } else { //n为偶数,ab大小都是n / 2
                queueB.add(num);
                queueA.add(queueB.poll());
            }
        }

        public double findMedian() {
            //如果是奇数，则就是a的堆顶元素
            //如果是偶数，则是两个堆顶元素相加 / 2
            return queueA.size() != queueB.size() ? queueA.peek() : (queueA.peek() + queueB.peek()) / 2.0;
        }
    }
}
