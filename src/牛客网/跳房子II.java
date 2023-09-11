package 牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 跳房子，也叫跳飞机，是一种世界性的儿童游戏。
 * 游戏参与者需要分多个回合按顺序跳到第1格直到房子的最后一格，然后获得一次选房子的机会，直到所有房子被选完，房子最多的人获胜。
 * 跳房子的过程中，如果有踩线等违规行为会结束当前回合，甚至可能倒退几步。
 * 假设房子的总格数是count，小红每回合可能连续跳的步数都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红三个回合跳到最后一格？如果有，请输出索引和最小的步数组合(数据保证索引和最小的步数组合是唯一的)。
 * 输入描述
 *
 * 第一行输入为房子总格数count，它是int整数类型。
 * 第二行输入为每回合可能连续跳的步数，它是int整数数组类型。
 *
 * 输出描述
 *
 * 返回索引和最小的满足要求的步数组合（顺序保持steps中原有顺序）
 */
public class 跳房子II {
    //最小索引和
    public static int min = Integer.MAX_VALUE;
    //房子总数
    public static int count;
    //最终结果
    public static List<Integer> resList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().replace("[", "")
                .replace("]", "")
                .split(",");
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        count = sc.nextInt();
        combine(ints, 3, new ArrayList<>(), new ArrayList<>(), 0);
        System.out.println(resList.toString());
    }
    /**
     * M 中取 N 个数字
     *
     * @param ints      steps数组
     * @param n         步数
     * @param list      小红跳的步数集合
     * @param indexList 小红跳的步数的索引集合
     * @param index     当前步数索引
     */
    public static void combine(int[] ints, int n, List<Integer> list, List<Integer> indexList, int index) {
        /*递归出口，游戏结束*/
        if (n == 0) {
            /*总步数*/
            int total = 0;
            /*总索引和*/
            int indexTotal = 0;
            for (int i = 0; i < 3; i++) {
                total += list.get(i);
                indexTotal += indexList.get(i);
            }
            if (total == count && indexTotal < min) {
                //走完所有房子且索引和比之前的小，则更新最小索引
                min = indexTotal;
                resList = new ArrayList<>(list);
            }
        } else {
            for (int i = index; i < ints.length; i++) {
                /*添加步数和索引*/
                list.add(ints[i]);
                indexList.add(i);
                /*进入下一层：步数--，索引++*/
                combine(ints, n - 1, list, indexList, i + 1);
                /*回溯：移除最近的索引和步数*/
                list.remove(list.size() - 1);
                indexList.remove(indexList.size() - 1);
            }
        }
    }
}
