/**
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/submissions/
 */
public class _557_反转字符串中的单词III {
    //根据空格，一个个翻转单词
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0 ,j = 0;
        while (j < chars.length) {
            //j一直往前扫描，直到遇到空格，翻转空格前的字符串
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars , i , j- 1);
            i = j + 1; //i是新一个单词的开头
            j++;
        }
        return new String(chars);
    }

    /**
     * 翻转指定区域的字符
     * @param chars
     * @param start
     * @param end
     */
    private void reverse(char[] chars , int start , int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end--;
            start++;
        }
    }
}
