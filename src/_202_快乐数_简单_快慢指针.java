/**
 * https://leetcode.cn/problems/happy-number/
 */
public class _202_快乐数_简单_快慢指针 {
    //查找是否有环
    public boolean isHappy(int n) {
        int slow = n;//慢指针，每次走1步
        int fast  = getNext(n); //快指针，每次走2步
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;//如果是快乐数，fast首先到达1，不是快乐数，slow和fast在某处相遇。
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
