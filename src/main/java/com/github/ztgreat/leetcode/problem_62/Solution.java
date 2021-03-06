package com.github.ztgreat.leetcode.problem_62;



class Solution {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }

                if(i==0 ){
                    dp[i][j]=dp[i][j-1];
                }else if(j==0){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }

            }
        }
        return dp[m-1][n-1];

    }

    //方法2,数字大会溢出
    // C(n-1+m-1,n-1),总共需要走n-1+m-1步，其中 n-1 是 横着走的
}