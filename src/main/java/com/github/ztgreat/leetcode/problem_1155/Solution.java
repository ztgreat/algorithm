package com.github.ztgreat.leetcode.problem_1155;


class Solution {

    public int numRollsToTarget(int d, int f, int target) {


        //可以优化为1维
        int [][]dp=new int[d+1][target+1];

        dp[1][0]=0;

        for (int i=1;i<=f && i<=target;i++){
            dp[1][i]=1;
        }
        for (int i=1;i<=d;i++){
            for (int j=1;j<=target;j++){
                for (int k=1;k<=f;k++){
                    if(j>=k && dp[i-1][j-k]>0){
                        dp[i][j]+=dp[i-1][j-k];
                        if(dp[i][j]>=1000000007){
                            dp[i][j] =dp[i][j] % 1000000007;
                        }
                    }
                }
            }
        }
        return dp[d][target];

    }


}