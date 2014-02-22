public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int curGasLeft = 0, totalGasLeft = 0, start = 0;
        for(int i = 0; i < len; i++) {
        	curGasLeft += (gas[i]-cost[i]);
        	totalGasLeft += (gas[i]-cost[i]);
        	if(curGasLeft < 0) {
        		start = i+1;
        		curGasLeft = 0;
        	}
        }
        return totalGasLeft >= 0 ? start : -1;
    }
}