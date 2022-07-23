import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 * @author shenchunxing
 *
 */
public class _139_单词拆分_中等_动态规划 {
	//动态规划：dp[i]表示字符串s前i个字符组成的字符串s1是否可以被空格拆分成字典中的若干个单词
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		Set<String> wordSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[len];
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				//字符串被分割成2部分，s[0,j],s[j,i]
				//dp[j]表示s[0,j]是否在范围内，
				//wordSet.contains(s.substring(j,i))表示s[j,i]是否在范围内
				//如果都在范围内，说明s[0,i]是可以拆分的
				if (dp[j] && wordSet.contains(s.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
    }
}
