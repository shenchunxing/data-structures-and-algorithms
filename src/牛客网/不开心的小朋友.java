package 牛客网;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 游乐场里增加了一批摇摇车，非常受小朋友欢迎，但是每辆摇摇车同时只能有一个小朋友使用，如果没有空余的摇摇车，需要排队等候，或者直接离开，最后没有玩上的小朋友会非常不开心。
 * 请根据今天小朋友的来去情况，统计不开心的小朋友数量。
 *
 * 摇摇车数量为N，范围是: 1 ≤ N < 10；
 * 每个小朋友都对应一个编码，编码是不重复的数字，今天小朋友的来去情况，可以使用编码表示为：1 1 2 3 2 3。
 * (若小朋友离去之前有空闲的摇摇车，则代表玩耍后离开；不考虑小朋友多次玩的情况)。小朋友数量 ≤ 100
 * 题目保证所有输入数据无异常且范围满足上述说明。
 *
 * 输入描述
 *
 * 第一行: 摇摇车数量
 * 第二行: 小朋友来去情况
 *
 * 输出描述
 *
 * 返回不开心的小朋友数量
 */
public class 不开心的小朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] kids = sc.nextLine().split(" ");
        System.out.println(getResult(n, kids));
    }
    public static int getResult(int n, String[] kids) {
        // 不开心的小朋友数量
        int unHappy = 0;
        // 已在摇摇车上的小朋友编号
        HashSet<String> playing = new HashSet<>();
        // 正在排队的小朋友编号
        LinkedList<String> waiting = new LinkedList<>();
        for (String kid : kids) {
            if (playing.contains(kid)) {
                // 如果kid是摇摇车上的小朋友编号, 则代表kid玩好了要离开
                playing.remove(kid);
                // 如果kid离开后，摇摇车有空位了，如果此时有人排队，则让排队的人上车玩
                if (waiting.size() > 0) {
                    playing.add(waiting.removeFirst());
                }
                continue;
            }
            // 如果kid不是摇摇车上的小朋友，则检查kid是不是排队的小朋友
            int index = waiting.indexOf(kid);
            if (index != -1) {
                // 如果是排队的小朋友，则说明kid没有玩到摇摇车，因此会不开心的离开
                unHappy++;
                waiting.remove(index);
                continue;
            }
            // 如果kid既不是摇摇车上的小朋友，也不是排队的小朋友，则是新来的小朋友
            if (playing.size() < n) {
                // 如果摇摇车还有空位，则直接玩
                playing.add(kid);
            } else {
                // 如果摇摇车没有空位了，则需要排队
                waiting.add(kid);
            }
        }
        return unHappy;
    }
}
