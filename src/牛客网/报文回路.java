package 牛客网;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * IGMP 协议中响应报文和查询报文，是维系组播通路的两个重要报文，
 * 在一条已经建立的组播通路中两个相邻的 HOST 和 ROUTER，
 * ROUTER 会给 HOST 发送查询报文，HOST 收到查询报文后给 ROUTER 回复一个响应报文，
 * 以维持相之间的关系，一旦这关系断裂，那么这条组播通路就异常”了。
 * 现通过某种手段，抓取到了 HOST 和 ROUTER 两者通讯的所有响应报文和查询报文，请分析该组播通路是否“正常”。
 *
 * 输入描述
 *
 * 第一行抓到的报文数量C (C≤100) ，后续C行依次输入设备节点D1和D2，表示从D1到D2发送了单向的报文，D1和D2用空格隔开。
 *
 * 输出描述
 *
 * 组播通路是否“正常”，正常输出True， 异常输出False。
 * 输入
 *
 * 5
 * 1 2
 * 2 3
 * 3 2
 * 1 2
 * 2 1
 *
 * 输出
 *
 * True
 */
public class 报文回路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, HashSet<Integer>> trans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int send = sc.nextInt();
            int receive = sc.nextInt();
            /*注意：putIfAbsent方法在指定的键尚未存在于映射中，会映射。如果键已经存在，该方法不会修改映射，并且会返回与键关联的现有值。*/
            /*此处这么使用是为了尽快创建出哈希表映射才让send和receive一起创建*/
            trans.putIfAbsent(send, new HashSet<>());
            trans.putIfAbsent(receive, new HashSet<>());
            /*实际只有一张表，表里面是key和哈希set，set就是receive的集合*/
            trans.get(send).add(receive);
        }
        System.out.println(getResult(trans));
    }
    public static String getResult(HashMap<Integer, HashSet<Integer>> trans) {
        for (Integer send : trans.keySet()) {
            /*send是发送方的id*/
            for (Integer receive : trans.get(send)) {
                /*receive是接收方的id*/
                if (!trans.get(receive).contains(send)) {
                    return "False";
                }
            }
        }
        return "True";
    }
}
