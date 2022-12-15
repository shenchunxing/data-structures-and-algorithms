/**
 * https://leetcode.cn/problems/gas-station/
 */
public class _134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0; //总剩余油量，标记是否可以完整走一圈
        int current_tank = 0;//当前剩余油量，标记从start站点出发，是否可以完整走一圈
        int start = 0; //开始出发的位置，默认0号加油站
        for (int i = 0; i < gas.length;i++) {
            total_tank += gas[i] - cost[i];
            current_tank += gas[i] - cost[i];
            if (current_tank < 0 ) { //无法到达i+1加油站
                start = i + 1; //重新设定出发加油站为i+1，继续尝试
                current_tank = 0;//清空当前剩余油量
            }
        }
        return total_tank >=0 ? start : -1;
    }
}
