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
        if (n - m == 1) {
            return oneInsert(first,second);
        } else if (m - n == 1) {
            return oneInsert(second,first);
        } else if (m == n) { //长度相等
            boolean foundDifference = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) { //比较每个字符
                    if (!foundDifference) { //第一次找到不同
                        foundDifference = true;
                    } else { //说明有多个字符不相同
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断较短的字符串和较长的字符串是否只需要一次操作就可以完成转换
     * @param shorter
     * @param longer
     * @return
     */
    private boolean oneInsert(String shorter , String longer) {
        int length1 = shorter.length(),length2 = longer.length();
        int index1 = 0,index2 = 0;
        while (index1 < length1 && index2 < length2) {
            //如果相同，则index1+=
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
            }
            index2++;
            //如果比较的下标超过1，说明不能通过一次转换就能完成的，返回false
            if (index2 - index1 > 1) {
                return false;
            }
        }
        return true;
    }
}
