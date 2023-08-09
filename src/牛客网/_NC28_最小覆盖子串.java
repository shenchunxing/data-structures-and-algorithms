package 牛客网;

/**
 * 给出两个字符串 s 和 t，要求在 s 中找出最短的包含 t 中所有字符的连续子串。
 */
public class _NC28_最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow("XDOYEZODEYXNZ","XYZ"));
    }
    static public String minWindow (String S, String T) {
        char[] chars = S.toCharArray(), chart = T.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        /*存储字符串T中的每种字符的个数，用负值*/
        for (char ch : chart) hash[ch]--;

        String res = "";
        /*i和j分别表示左右边界*/
        /*注意：cnt表示滑动窗口中已包含字符T中的字符的数量*/
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            /*记录S总的字符个数，抵消T的字符*/
            hash[chars[i]]++;
            /*当字符S中的当前字符出现次数不大于字符T中的出现次数时，将cnt计数器加一*/
            if (hash[chars[i]] <= 0) cnt++;
            /*窗口中包含所有字符T中的字符时，尝试缩小窗口，即左边界右移。同时，更新哈希表和cnt计数器*/
            while (cnt == m && hash[chars[j]] > 0) hash[chars[j++]]--;
            /*当窗口中包含所有字符T中的字符时，更新最小窗口子串res。如果res为空字符串或当前窗口的长度小于res的长度，更新res为当前窗口的子串。，*/
            /*这里res.equals("")判断是因为默认res就是为空，直接赋值就行。*/
            if (cnt == m)
                if (res.equals("") || res.length() > i - j + 1)
                    res = S.substring(j, i + 1);
        }
        return res;
    }
}
