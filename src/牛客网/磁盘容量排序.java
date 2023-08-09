package 牛客网;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 磁盘的容量单位常用的有M，G，T这三个等级，它们之间的换算关系为1T = 1024G，1G = 1024M，现在给定n块磁盘的容量，
 *
 * 请对它们按从小到大的顺序进行稳定排序，例如给定5块盘的容量，1T，20M，3G，10G6T，3M12G9M排序后的结果为20M，3G，3M12G9M，1T，10G6T。
 *
 * 注意单位可以重复出现，上述3M12G9M表示的容量即为3M+12G+9M，和12M12G相等。
 *
 * 输入描述
 *
 * 输入第一行包含一个整数n(2 <= n <= 100)，表示磁盘的个数，接下的n行，每行一个字符串(长度大于2，小于30)，表示磁盘的容量，
 *
 * 由一个或多个格式为mv的子串组成，其中m表示容量大小，v表示容量单位，例如20M，1T，30G，10G6T，3M12G9M。
 *
 * 磁盘容量m的范围为1到1024的正整数，容量单位v的范围只包含题目中提到的M，G，T三种，换算关系如题目描述。
 *
 * 输出描述
 *
 * 输出n行，表示n块磁盘容量排序后的结果。
 */
public class 磁盘容量排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*输入n*/
        int n = sc.nextInt();
        /*换行*/
        sc.nextLine();
        int[][] num = new int[n][2];    //用来放置磁盘索引和单位转换成M之后的数值
        Map<Integer, String> map = new HashMap<>(); //用来放置磁盘索引和磁盘原数值
        for (int i = 0; i < n; i++) {
            int sum = 0;
            /*index表示每个容量数字部分的起始位置*/
            int index = -1;
            /*每一行数据*/
            String str = sc.nextLine();
            /*哈希表记录下原始的值和位置，最后打印需要*/
            map.put(i + 1, str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'M') {
                    /*求和*/
                    sum += Integer.parseInt(str.substring(index + 1, j));
                    /*重新设置位置，可能还有数字*/
                    index = j;
                } else if (str.charAt(j) == 'G') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (str.charAt(j) == 'T') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            /*记录序号*/
            num[i][0] = i + 1;
            /*到这里，每个容量都被转成M大小了*/
            num[i][1] = sum;
        }
        /*根据磁盘从小到大排序，如果相等，序号小的在前*/
        Arrays.sort(num, (e1, e2) -> (e1[1] == e2[1] ? (e1[0] - e2[0]) : (e1[1] - e2[1])));
        /*num已经是排序后的数组，而哈希表刚才记录了原始位置和值，拿出来即可。最后一行不需要换行。其余行需要换行输出*/
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(map.get(num[i][0]));
            } else {
                System.out.println(map.get(num[i][0]));
            }
        }
    }
}
