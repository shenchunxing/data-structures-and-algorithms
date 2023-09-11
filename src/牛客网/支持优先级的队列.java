package 牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 实现一个支持优先级的队列，高优先级先出队列；同优先级时先进先出。
 *
 * 如果两个输入数据和优先级都相同，则后一个数据不入队列被丢弃。
 *
 * 队列存储的数据内容是一个整数。
 * 输入描述
 *
 * 一组待存入队列的数据（包含内容和优先级）
 *
 * 输出描述
 *
 * 队列的数据内容（优先级信息输出时不再体现）
 */
public class 支持优先级的队列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] string = sc.nextLine().replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .split(",");
        //优先级队列
        PriorityQueue<Task> queue = new PriorityQueue<>();
        /*每两个为一组*/
        for (int i = 0; i < string.length; i += 2) {
            /*内容*/
            int a = Integer.parseInt(string[i]);
            /*值*/
            int b = Integer.parseInt(string[i + 1]);
            Task task = new Task(a, b);
            /*加入队列*/
            queue.add(task);
        }
        /*这里的优先级队列已经排序好了的*/
        List<Integer> resList = new ArrayList<>();
        //等待记录的task
        Task waitTask = queue.poll();
        while (waitTask != null) {
            Task topTask = queue.peek();
            /*如果不相等，就把内容加入*/
            if (!waitTask.equals(topTask)) {
                //两个task不相等则记录
                resList.add(waitTask.data);
            }
            /*完全相等，则丢弃*/
            waitTask = queue.poll();
        }
        System.out.println(resList);
    }
    static class Task implements Comparable<Task> {
        int data;
        int id;
        public Task(int data, int id) {
            this.data = data;
            this.id = id;
        }
        /*比较优先级，id大的在前*/
        @Override
        public int compareTo(Task o) {
            return o.id - this.id;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return data == task.data &&
                    id == task.id;
        }
    }
}
