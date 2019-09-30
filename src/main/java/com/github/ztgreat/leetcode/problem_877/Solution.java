package com.github.ztgreat.leetcode.problem_877;


class Solution {

    public boolean stoneGame(int[] piles) {


        //dp[i][j][0]=max(piles[i]+dp[i+1][j][1],piles[j]+dp[i][j-1][1])

        int n= piles.length;
        int [][][] dp= new int [n][n][2];

        for (int i=0;i<n;i++){
                dp[i][i][0]=piles[i];
                dp[i][i][1]=0;
        }

        int step=0;
        for (int i=0;i<n  && step<n;){
            step+=1;
            for (int j=step;j<n;){
                dp[i][j][0]=Math.max(piles[i]+dp[i+1][j][1],piles[j]+dp[i][j-1][1]);
                i++;
                j++;
            }
            i=0;

        }
        return dp[0][n-1][0]-dp[0][n-1][1]>0;
    }
}