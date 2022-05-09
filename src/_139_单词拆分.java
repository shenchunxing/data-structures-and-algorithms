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
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		int length = s.length();
		boolean[] dp = new boolean[length + 1];
		dp[0] = true;
		for (int i = 1 ; i <= length;i++) {
			for (int j = 0; j < i;j++) {
				//s[0 j]是符合的字符串 && s[j ,i]包含在哈希set里面，说明s[0,i]是符合的字符串
				if (dp[j] && wordDictSet.contains(s.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[length];
    }
}
