package com.github.ztgreat.leetcode.problem_931;


class Solution {

    public int minFallingPathSum(int[][] A) {

        if(A==null){
            return 0;
        }

        int n= A.length;
        int [][] dp=new int [n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(j==0){
                    if(i==0){
                        dp[i][j]=A[i][j];
                        continue;
                    }
                    dp[i][j]=Math.min(dp[i-1][j+1]+A[i][j],dp[i-1][j]+A[i][j]);
                    continue;
                }
                if(i==0){
                    dp[i][j]=A[i][j];
                    continue;
                }
                if(j+1==n){
                    dp[i][j]=Math.min(dp[i-1][j-1]+A[i][j],dp[i-1][j]+A[i][j]);
                    continue;
                }
                dp[i][j]=Math.min(dp[i-1][j-1]+A[i][j],dp[i-1][j+1]+A[i][j]);
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+A[i][j]);
            }
        }

        int res=Integer.MAX_VALUE;

        for (int i=0;i<n;i++){
            res=Math.min(dp[n-1][i],res);
        }
        return res;

    }

}