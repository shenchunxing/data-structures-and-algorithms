package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * File: null.java
 * Author: shenchunxing
 * Date: 2023/8/9
 * 公司最近准备进行拔河比赛，需要在全部员工中进行挑选。
 *
 * 选拔的规则如下：
 * 按照身高优先、体重次优先的方式准备比赛阵容；
 * 规定参赛的队伍派出10名选手。
 * 请实现一个选拔队员的小程序。
 * 输入为一个数组，记录了部门人员的身高、体重信息，如[身高,体重]的方式放置；
 * 部门全部成员数量为大于10的一个数组。
 * 要求输出一个size为10的二维数组。
 *
 * 输入为N行员工信息，表示部门报名参加选拔的候选人信息，每行有两个数字，使用空格分隔，表示员工的身高、体重信息
 * 如
 * 181 70
 * 182 70
 * 表示两位候选员工，第一人身高181厘米，体重70公斤;第二人身高182厘米，体重70公斤
 *
 * 输出描述
 *
 * 要求输出一个10行的已经排序的参赛员工信息数据，每行有两个数字，使用空格分隔，表示员工的身高、体重信息如
 * 182 70
 * 181 70
 */
public class 拔河比赛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("".equals(line)) {
                getResult(employees);
                break;
            } else {
                employees.add(new Employee(line));
            }
        }
    }
    public static void getResult(ArrayList<Employee> employees) {
        /*排序方式，升高优先，体重其次*/
        employees.sort((a, b) -> a.height != b.height ? b.height - a.height : b.weight - a.weight);
        for (int i = 0; i < 10; i++) {
            System.out.println(employees.get(i));
        }
    }
    static class Employee {
        int height;
        int weight;
        public Employee(String s) {
            int[] tmp = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            this.height = tmp[0];
            this.weight = tmp[1];
        }
        @Override
        public String toString() {
            return this.height + " " + this.weight;
        }
    }
}
