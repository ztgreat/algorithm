package com.github.ztgreat.leetcode.problem_121;

/**
 * 思路:找最低点到最高点的差
 */
public class Solution {

    public   int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){

            if(prices[i]<minPrices){
                minPrices=prices[i];
            }
            if(prices[i]-minPrices>maxProfit){
                maxProfit = prices[i]-minPrices;
            }

        }
        return maxProfit;

    }

}
