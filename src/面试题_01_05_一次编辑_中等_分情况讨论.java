/**
 * https://leetcode.cn/problems/one-away-lcci/solution/yi-ci-bian-ji-by-leetcode-solution-2xkr/
 */
public class 面试题_01_05_一次编辑_中等_分情况讨论 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length() , n = second.length();
        //分情况讨论1次编辑：
        //往first插入一个字符，得到second，此时n - m = 1，其余字符都相同
        //往first删除一个字符，得到second，此时m - n = 1，其余字符都相同
        //将first中的一个字符替换成不同字符得到second，此时n = m，first和second恰好有一个字符不同。
        //0次编辑：则m = n，且first = second
            if (n == m + 1) {
                return insertOne(first,second);
            } else if (m == n + 1) {
                return insertOne(second,first);
            } else if (m == n) {
                boolean diff = false;
                //挨个比较
                for (int i = 0; i < m; i++) {
                    if (first.charAt(i) != second.charAt(i)) {
                        if (diff) return false;
                        diff = true;
                    }
                }
                return true;
            }
            return false;
    }

        private boolean insertOne(String first , String second) {
            int m = first.length() , n = second.length();
            int index1 = 0 , index2 = 0;
            while (index1 < m && index2 < n) {
                if (first.charAt(index1) == second.charAt(index2)) {
                    index1++;
                }
                index2++;
                if (index2 - index1 > 1) return false;
            }
            return true;
        }
}
