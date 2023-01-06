package 队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/remove-k-digits/
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字
 */
public class _402_移掉K位数字 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digital = num.charAt(i);
            //模拟一个双端队列，如果队列尾部比当前的值要大，让尾部出队，k--。继续比较直到尾部不大于当前值
            //这样确保了在队列中一直是一个单调递增的，出去的队尾都是较大的值。
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digital) {
                deque.pollLast();
                k--;
            }
            deque.offer(digital);
        }

        //如果删除了m个数比k小，需要额外从队尾删除k-m个数，因为k一直在k--，所以这里只要删除剩余的k个数就行
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder builder = new StringBuilder();
        //前置0需要去掉，直到第一个不是0的加到结果中去
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digital = deque.pollFirst();
            if (leadingZero && digital == '0') {
                continue;
            }
            leadingZero = false;
            builder.append(digital);
        }
        //长度为0说明都是前置0。直接返回0
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
