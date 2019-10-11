package com.github.ztgreat.leetcode.problem_718;


class Solution {

    public int findLength(int[] A, int[] B) {

        // 连续的 子数组

        int n=A.length;
        int m=B.length;

        if(n==0 || m==0){
            return 0;
        }

        //dp[i][j] 以 i,j 位置 字符为结尾的公共子数组的长度
        int [][]dp= new int[n+1][m+1];
        int max=0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    //dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                max=Math.max(max,dp[i][j]);
            }

        }
        return max;

    }

}