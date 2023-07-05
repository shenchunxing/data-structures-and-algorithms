package 字符串;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
/*2023-7-4*/
public class _557_反转字符串中的单词III {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    //根据空格，一个个翻转单词
   static public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        /*i用于确定每个单词的起始位置，j用于扫描单词*/
        int i = 0 ,j = 0;
        while (j < chars.length) {
            //j一直往前扫描，直到遇到空格，翻转空格前的字符串
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            /*翻转从i到j-1的位置，因为j是空格需要排除*/
            reverse(chars , i , j - 1);
            /*i从j + 1位置开始，i是单词的开头*/
            i = j + 1;
            j++;
        }
        return new String(chars);
    }

    /**
     * 翻转指定区域的字符
     */
    static private void reverse(char[] chars , int start , int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end--;
            start++;
        }
    }
}
