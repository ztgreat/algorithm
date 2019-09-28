package com.github.ztgreat.leetcode.problem_338;


class Solution {

    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        if(num==0){
            dp[0]=0;
            return dp;
        }
        if(num==1){
            dp[0]=0;
            dp[1]=1;
            return dp;
        }
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=num;i++){
            if((i&1)==0){
                dp[i]=dp[i/2];
            }else{
                dp[i]=dp[i/2]+1;
            }
        }
        return dp;
    }
}