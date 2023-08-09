package 牛客网;

import java.util.Scanner;

/**
 * 手上有一副扑克牌，每张牌按牌面数字记分（J=11,Q=12,K=13，没有大小王)，出牌时按照以下规则记分：
 * 出单张，记牌面分数，例如出一张2，得分为2
 * 出对或3张，记牌面分数总和再x2，例如出3张3，得分为(3+3+3)x2=18
 * 出5张顺，记牌面分数总和再x2，例如出34567顺，得分为(3+4+5+6+7)x2=50
 * 出4张炸弹，记牌面分数总和再x3，例如出4张4，得分为4x4x3=48
 * 求出一副牌最高的得分数。
 */
public class 最佳的出牌方法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }
    public static int getResult(String cards) {
        // 数组索引是牌面分数, 数组元素是牌面数量, 其中 0 索引不用
        int[] card_count = new int[14];
        // 统计各种牌的数量
        for (int i = 0; i < cards.length(); i++) {
            char card = cards.charAt(i);
            // 1-9输入为数字1-9，10输入为数字0，JQK输入为大写字母JQK
            // 1-9 牌面分数就是 1-9, 0的牌面分数是 10, J=11,Q=12,K=13, 可以发现牌面分数是连续的，可以和card_count数组的索引对应起来
            if (card == '0') card_count[10]++;
            else if (card == 'J') card_count[11]++;
            else if (card == 'Q') card_count[12]++;
            else if (card == 'K') card_count[13]++;
            else card_count[card - '0']++;
        }
        return getMaxScore(card_count);
    }
    // 获取牌的最大得分
    public static int getMaxScore(int[] card_count) {
        // 记录最大得分
        int score = 0;
        // 找顺子, 可能找出一副顺子后，剩余牌还能找出顺子，因此需要while循环找
        while (true) {
            // 五张连续牌 要是组成顺子 的增值分数 > 0, 则可以尝试组成顺子, 否则各论各的得分更高
            int maxProfit = 0;
            // 顺子的起始位置, card_count[0]是无用的，因此l=0表示没有顺子
            int l = 0;
            // 顺子起始位置只能是1~9, 因为12345是最先顺子, 90JQK是最后顺子
            for (int i = 1; i <= 9; i++) {
                // 组成顺子可得的增值分数
                int profit = getProfitForShunZi(card_count, i);
                // 一轮只找一个顺子，且需要找增值分数最大的那个顺子
                if (profit > maxProfit) {
                    // 记录最优顺子的增值分数
                    maxProfit = profit;
                    // 记录最优顺子的起始位置
                    l = i;
                }
            }
            // 如果本轮没有找到顺子, 则结束找顺子
            if (l == 0) break;
            // 找到顺子，则加入顺子分数，并从card_count中去掉顺子占用的牌
            for (int i = l; i <= l + 4; i++) {
                score += i * 2; // 顺子每张牌得分*2
                card_count[i]--;
            }
        }
        // 找完所有顺子后, 剩余牌各论各的得分
        for (int i = 1; i <= 13; i++) {
            score += getScore(card_count, i);
        }
        return score;
    }
    // 五张连续牌组成顺子 可获得的 增值分数
    public static int getProfitForShunZi(int[] card_count, int l) {
        int profit = 0;
        for (int i = l; i <= l + 4; i++) {
            // 如果给定l,r区间无法组成顺子, 则没有好处
            if (card_count[i] == 0) return Integer.MIN_VALUE;
            switch (card_count[i]) {
                case 1 : profit += i; break;// 单张 成为顺子一部分，则增值分数 i
                case 2 : profit -= i; break;// 对子 拆出一张给顺子, 剩余一张变成单张，则增值分数 -i
                case 4 : profit -= i * 4;break; // 炸弹 拆出一张给顺子，剩余三张变成三张，则增值分数 -4i
            }
        }
        return profit;
    }
    // 各论各的得分
    public static int getScore(int[] card_count, int i) {
        int score = 0;
        switch (card_count[i]) {
            case 1 : score += i; break;// 单张得分： i
            case 2 : score += i * card_count[i] * 2; break;// 对子 得分：i * 牌数量 * 2
            case 3 : score += i * card_count[i] * 2; break;// 三张 得分：i * 牌数量 * 2
            case 4 : score += i * card_count[i] * 3; break;// 炸弹得分：i * 牌数量 * 3
        }
        return score;
    }
}
