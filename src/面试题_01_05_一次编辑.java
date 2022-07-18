/**
 * https://leetcode.cn/problems/one-away-lcci/solution/yi-ci-bian-ji-by-leetcode-solution-2xkr/
 */
public class 面试题_01_05_一次编辑 {
    public boolean oneEditAway(String first, String second) {
        int lf = first.length() , ls = second.length();
        //默认second是较长的那个字符串
        if (lf > ls) return oneEditAway(second,first);
        if (ls - lf > 1) return false;
        if (ls == lf) {
           int count = 0;
            for (int i = 0; i < ls; i++) {
                if (first.charAt(i) != second.charAt(i)) count++;
            }
            return count <= 1;
        }
        //长度相差为1，需要确保first插入一个字符 == second
        int i = 0 , ofs = 0; //偏移量，大于1说明无法一次编辑
        while (i < lf) {
            if (first.charAt(i) != second.charAt(i + ofs)) {
                ofs++;
                if (ofs > 1) return false;
            } else {
                i++; //字符相等，则继续遍历
            }
        }
        return true;
    }
}
