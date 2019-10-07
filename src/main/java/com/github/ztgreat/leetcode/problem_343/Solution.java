package com.github.ztgreat.leetcode.problem_343;


class Solution {


    public int integerBreak(int n) {


        //dp[n]=i*dp[n-i];

       int []dp= new int[n+1];
       dp[2]=1;
       for (int i=3;i<=n;i++){
           for (int j=1;j<i;j++){
               dp[i]=Math.max(dp[i],j*dp[i-j]);
               dp[i]=Math.max(dp[i],j*(i-j));
           }
       }

       return dp[n];




    }

}