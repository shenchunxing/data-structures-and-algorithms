package 动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
/*2023-7-18*/
public class _139_单词拆分 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("pen");
		System.out.println(wordBreak("applepenapple",list));
	}
	//动态规划：dp[i]表示字符串s前i个字符组成的字符串s1是否可以被空格拆分成字典中的若干个单词
	static public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		int length = s.length();
		/*创建一个长度为 length + 1 的数组 dp 是为了方便处理子问题和边界情况*/
		boolean[] dp = new boolean[length + 1];
		dp[0] = true;
		for (int i = 1 ; i <= length;i++) {
			for (int j = 0; j < i;j++) {
				//s[0 ,j]是符合的字符串 && s[j ,i]包含在哈希set里面，说明s[0,i]是符合的字符串
				if (dp[j] && wordDictSet.contains(s.substring(j,i))) {
					dp[i] = true;
					/*已经找到，跳出当前的循环*/
					break;
				}
			}
		}
		return dp[length];
    }
}
