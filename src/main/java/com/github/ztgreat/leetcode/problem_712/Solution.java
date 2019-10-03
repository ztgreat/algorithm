package com.github.ztgreat.leetcode.problem_712;


class Solution {

    public int minimumDeleteSum(String s1, String s2) {

        int n=s1.length();
        int m= s2.length();
        int [][]dp = new int[n+1][m+1];

        int sumS1=0;
        int sumS2=0;
        for (int i=0;i<m;i++){
            sumS2+=s2.charAt(i);
        }

        for (int i=1;i<=n;i++){
            sumS1+=s1.charAt(i-1);
            for (int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return sumS1+sumS2-2*dp[n][m];
    }
}