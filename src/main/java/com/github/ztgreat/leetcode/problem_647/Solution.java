package com.github.ztgreat.leetcode.problem_647;


class Solution {

    public int countSubstrings(String s) {

        if(s==null){
            return 0;
        }

        if(s.length()==0 || s.length()==1){
            return 1;
        }

        int n = s.length();
        int [][]dp=new int[n][n];

        for (int i=n-1;i>=0;i--){
            for (int j=i;j<n;j++){

                if(i==j){
                    dp[i][j]=1;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){

                    if(i == n - 1 || i+1==j){
                        dp[i][j]=1;
                        continue;
                    }
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    dp[i][j]=0;
                }
            }
        }

        int sum=0;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                sum+=dp[i][j];
            }
        }

        return sum;

    }
}