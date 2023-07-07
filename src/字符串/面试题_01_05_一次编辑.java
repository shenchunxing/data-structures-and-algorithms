package 字符串;

/**
 * https://leetcode.cn/problems/one-away-lcci/solution/yi-ci-bian-ji-by-leetcode-solution-2xkr/
 * 难度：中等
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
/*2023-7-7*/
public class 面试题_01_05_一次编辑 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale","ple"));
        System.out.println(oneEditAway("pales","pal"));
    }
    static public boolean oneEditAway(String first, String second) {
        int m = first.length() , n = second.length();
        /*长度>=2，直接false*/
        if (Math.abs(m - n) > 1) return false;
        //分情况讨论1次编辑：
        //往first插入一个字符，得到second，此时n - m = 1，其余字符都相同
        //往first删除一个字符，得到second，此时m - n = 1，其余字符都相同
        //将first中的一个字符替换成不同字符得到second，此时n = m，first和second恰好有一个字符不同。
        //0次编辑：则m = n，且first = second

            /*往first插入一个字符，得到second，此时n - m = 1，其余字符都相同*/
            if (n == m + 1) {
                return insertOne(first,second);
            /*往first删除一个字符，得到second，此时m - n = 1，其余字符都相同    */
            } else if (m == n + 1) {
                return insertOne(second,first);
            /*将first中的一个字符替换成不同字符得到second，此时n = m，first和second恰好有一个字符不同*/
            } else if (m == n) {
                boolean diff = false;/*标记唯一的那个不匹配的字符*/
                //挨个比较
                for (int i = 0; i < m; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        if (diff) return false;/*再次出现不同，说明至少有2处不同，直接false*/
                        diff = true;
                    }
                }
                return true;
            }
            return false;
    }

    /*注意：长度上first比second小1，依次匹配first和second的每个字符*/
    static private boolean insertOne(String first , String second) {
            int m = first.length() , n = second.length();
            int index1 = 0 , index2 = 0;
            while (index1 < m && index2 < n) {
                /*如果first和second匹配到相同的字符，则继续匹配first的下一个字符index++*/
                if (first.charAt(index1) == second.charAt(index2)) {
                    index1++;
                }
                index2++;
                /*一旦出现间距 > 1。直接false*/
                if (index2 - index1 > 1) return false;
            }
            return true;
        }
}
