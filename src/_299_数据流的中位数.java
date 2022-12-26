import java.util.PriorityQueue;
import java.util.Queue;

public class _299_数据流的中位数 {
    public static void main(String[] args) {
        _299_数据流的中位数 medianFinder = new _299_数据流的中位数();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());
    }
    //中位数出现在小顶堆的堆顶 或者 大顶堆的堆顶、小顶堆的堆顶取平均值
    Queue<Integer> queueA,queueB;
    /** initialize your data structure here. */
    public _299_数据流的中位数() {
        queueA = new PriorityQueue<>(); //小顶堆,保存较大的一半数据
        queueB = new PriorityQueue<>((x , y) -> (y - x));//大顶堆，保存较小的一半数据
    }

    public void addNum(int num) {
        //5 2 4 3 1 6
        //优先小顶堆，为了维护堆的性质和大顶堆放较小的数，小顶堆放较大的数，每次先添加到堆里，是为了维护堆的性质，再poll出来添加到
        //另一个堆是为了保持两个堆的平衡
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
