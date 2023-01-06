package 动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 * @author shenchunxing
 *
 */
public class _139_单词拆分 {
	//动态规划：dp[i]表示字符串s前i个字符组成的字符串s1是否可以被空格拆分成字典中的若干个单词
	static public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		Set<String> wordSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[len];
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				//首先确保dp[j]必须是可拆分的，然后剩下的单词长度s.substring(j,i)又在数组中
				if (dp[j] && wordSet.contains(s.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
    }
}
