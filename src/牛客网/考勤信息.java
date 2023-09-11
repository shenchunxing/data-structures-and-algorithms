package 牛客网;

import java.util.Scanner;

/**
 * 公司用一个字符串来表示员工的出勤信息
 *
 * absent：缺勤
 *
 * late：迟到
 *
 * leaveearly：早退
 *
 * present：正常上班
 *
 * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
 *
 * 缺勤不超过一次；
 *
 * 没有连续的迟到/早退；
 *
 * 任意连续7次考勤，缺勤/迟到/早退不超过3次。
 *
 * 输入描述
 *
 * 用户的考勤数据字符串，记录条数 >= 1；
 *
 * 输入字符串长度 < 10000；
 *
 * 不存在非法输入
 *
 * 如：
 *
 * 2
 *
 * present
 *
 * present absent present present leaveearly present absent
 *
 * 输出描述
 *
 * 根据考勤数据字符串，如果能得到考勤奖，输出”true”；否则输出”false”，
 *
 * 对于输入示例的结果应为：
 *
 * true false
 */
public class 考勤信息 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        /*二维数组记录每次考勤*/
        String[][] logs = new String[n][];
        for (int i = 0; i < n; i++) {
            logs[i] = in.nextLine().split(" ");
        }
        /*每次考勤需要去判断是否符合考勤奖*/
        for (int j = 0; j < n; j++) {
            int count = 0;
            /*记录出问题的次数*/
            int total = 0;
            boolean flag = true;
            /*是否有考勤奖*/
            boolean skip_flag = true;
            /*单次的考勤记录*/
            for (int i = 0; i < logs[j].length; i++) {
                switch (logs[j][i]) {
                    /*缺勤不超过1次*/
                    case "absent":
                        if (++count > 1) flag = false;
                        total++;
                        break;
                        /*没有连续的迟到*/
                    case "late":
                        if (i > 0 && logs[j][i - 1].equals("late")) flag = false;
                        total++;
                        break;
                    /*没有连续的早退*/
                    case "leaveearly":
                        if (i > 0 && logs[j][i - 1].equals("leaveearly")) flag = false;
                        total++;
                        break;
                }
                /*不满足了，直接退出循环*/
                if (!flag) {
                    System.out.println("false");
                    skip_flag = false;
                    break;
                }
                /*任意连续7次考勤，去掉前7天的有问题的状态*/
                if (i >= 7 && !logs[j][i - 7].equals("present")) {
                    total--;
                }
                /*缺勤/迟到/早退不超过3次*/
                if (total > 3) {
                    System.out.println("false");
                    skip_flag = false;
                    break;
                }
            }
            if (skip_flag) {
                System.out.println("true");
            }
        }
    }
}
