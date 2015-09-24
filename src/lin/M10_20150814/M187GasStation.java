package lin.M10_20150814;

/**
 * Created by Paul on 8/13/15.
 * http://www.lintcode.com/en/problem/gas-station/
 */
//Gas Station
//
//        29% Accepted
//        There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//        Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.
//
//        Note
//        The solution is guaranteed to be unique.
//
//        Challenge
//        O(n) time and O(1) extra space
public class M187GasStation {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null || gas.length == 0 || cost == null || cost.length != gas.length) {
            return -1;
        }

        int dis = 0;
        for(int i : gas) {
            dis += i;
        }

        int costs = 0;
        for(int i : cost) {
            costs += i;
        }

        if(dis < costs) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int index = -1;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum<0) {
                index = i;
                sum = 0;
            }
        }


        return total < 0 ? -1 : index + 1;
    }
}
