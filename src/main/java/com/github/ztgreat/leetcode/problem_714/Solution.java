package com.github.ztgreat.leetcode.problem_714;


class Solution {


    public int maxProfit(int[] prices, int fee) {

        if(prices==null){
            return 0;
        }
        int n=prices.length;
        int[][] dp = new int[n][2];
        for (int i=0;i<n;i++){

            if(i==0){
                dp[i][0]=0;
                //查看 dp[i][0]的递推关系
                dp[i][1]=-fee-prices[0];
                continue;
            }

            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];

    }
}