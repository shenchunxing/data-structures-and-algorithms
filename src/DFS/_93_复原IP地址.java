package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/restore-ip-addresses/
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class _93_复原IP地址 {
    public static void main(String[] args) {
        _93_复原IP地址 ob = new _93_复原IP地址();
        System.out.println( ob.restoreIpAddresses("25525511135"));
    }

    List<String> res = new LinkedList<String>();
    List<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return res; //构成不了ip
        backtrack(s,0,0);
        return res;
    }

    private void backtrack(String s , int splitIndex , int level) {
        if (level == 4) { //到达了终点
            res.add(String.join(".",path));
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            //每一次分割之后，对剩余字符长度是否合理进行判断，剪枝操作，优化运行速度
            if ((s.length() - i - 1) > 3 * (3 - level)) continue;
            //如果分割的字符串不是合理的IP地址，跳过
            if (!isValidIp(s.substring(splitIndex,i + 1))) continue;
            //把合法的IP地址段加入path存储
            path.add(s.substring(splitIndex,i + 1));
            //每次把分割线往后移一位，且段数level+1
            backtrack(s,i + 1,level + 1);
            //进行回溯操作
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断是否是有效的ip
     */
    private boolean isValidIp(String s) {
        //判断其是否含有前导，同时位数大与1
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        //长度为4就直接舍弃，加上这一步是为了后面parseInt做准备,防止超过了Integer可以表示的整数范围
        if (s.length() > 3) return false;
        //将字符转为int判断是否大于255，因为题目明确说了只由数字组成，所以这里没有对非数字的字符进行判断
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }
}
