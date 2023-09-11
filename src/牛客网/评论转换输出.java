package 牛客网;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 在一个博客网站上，每篇博客都有评论。每一条评论都是一个非空英文字母字符串。
 * 评论具有树状结构，除了根评论外，每个评论都有一个父评论。
 * 当评论保存时，使用以下格式：
 *
 * 首先是评论的内容；
 *
 * 然后是回复当前评论的数量。
 *
 * 最后是当前评论的所有子评论。（子评论使用相同的格式嵌套存储）
 *
 * 所有元素之间都用单个逗号分隔。
 * 例如，如果评论如下：
 * 第一条评论是”hello,2,ok,0,bye,0″，第二条评论是”test,0″，第三条评论是”one,1,two,1,a,0″。
 * 所有评论被保存成”hello,2,ok,0,bye,0,test,0,one,1,two,1,a,0″。
 *
 * 对于上述格式的评论，请以另外一种格式打印：
 * 首先打印评论嵌套的最大深度。
 * 然后是打印n行，第i（1<=i<=n)行对应于嵌套级别为i的评论（根评论的嵌套级别为1）。
 * 对于第i行，嵌套级别为i的评论按照它们出现的顺序打印，用空格分隔开。
 *
 * 输入描述
 *
 * 一行评论。由英文字母、数字和英文逗号组成。
 * 保证每个评论都是由英文字符组成的非空字符串。
 * 每个评论的数量都是整数（至少由一个数字组成）。
 * 整个字符串的长度不超过106。
 * 给定的评论结构保证是合法的。
 *
 * 输出描述
 *
 * 按照给定的格式打印评论。对于每一级嵌套，评论应该按照输入中的顺序打印
 */
public class 评论转换输出 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        //评论的集合
        List<Node> nodeList = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < strings.length; i += 2) {
            //当前评论的内容
            String content = strings[i];
            //当前评论有几个回复
            int child = Integer.parseInt(strings[i + 1]);
            //初始化层数
            int row = 1;
            //从后往前遍历
            for (int j = nodeList.size() - 1; j >= 0; j--) {
                Node node = nodeList.get(j);
                if (node.child != 0) {
                    //如果这个节点还有子节点，那就属于这个节点
                    node.child--;
                    row = node.row + 1;
                    break;
                }
            }
            Node node = new Node(row, content, child);
            nodeList.add(node);
            /*保存层级和每一层的内容，每一层的内容用空格拼接*/
            map.put(row, map.getOrDefault(row, "") + content + " ");
        }
        for (String str : map.values()) {
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
    static class Node {
        private int row;
        private String content;
        private int child;
        /**
         * @param row     评论层数
         * @param content 评论内容
         * @param child   评论回复
         */
        public Node(int row, String content, int child) {
            this.row = row;
            this.content = content;
            this.child = child;
        }
    }
}
