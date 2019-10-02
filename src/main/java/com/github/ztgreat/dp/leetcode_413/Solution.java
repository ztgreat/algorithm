package com.github.ztgreat.dp.leetcode_413;


class Solution {


    //注意：是连续划分，不能跳跃

    public int numberOfArithmeticSlices(int[] A) {

        if(A==null || A.length<3){
            return 0;
        }

        int n=A.length;
        int[][] dp = new int[n][n];

        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
                if(i==j){
                    dp[i][j]=0;
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){

                if(i+1==j){
                    dp[i][j]=A[j]-A[i];
                    continue;
                }
                if(A[j]-A[j-1]==dp[i][j-1]){
                    dp[i][j]=dp[i][j-1];
                }else{
                    break;
                }
            }
        }
        int sum=0;
        for (int i=0;i<n;i++){
            for (int j=i+2;j<n;j++){

                if(dp[i][j]!=Integer.MAX_VALUE){
                    sum++;
                }
            }
        }
        return sum;
    }
}