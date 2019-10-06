package com.github.ztgreat.leetcode.problem_516;


class Solution {


    public int longestPalindromeSubseq(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        if(s.length()==1){
            return 1;
        }

        int n= s.length();

        int [][]dp=new int[n][n];

        for (int i=n-1;i>=0;i--){
            for (int j=i;j<n;j++){

                if(i==j){
                    dp[i][j]=1;
                    continue;
                }
                if(i+1==j){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=1;
                    }
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=Math.max(dp[i][j],dp[i+1][j-1]+2);
                }else{
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
                    dp[i][j]=Math.max(dp[i][j],dp[i+1][j]);
                }

            }
        }
        return dp[0][n-1];

    }


}