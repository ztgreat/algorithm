package com.github.ztgreat.dp.leetcode_5;


class Solution {

    public String longestPalindrome(String s) {
        if(s==null || s.length()==1 || s.length()==0){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int n=s.length();
        int start=0,end=0;
        for(int i=n-1;i>=0;i--){
            for (int j=i;j<n;j++){

                if(s.charAt(i)!=s.charAt(j)){
                    continue;
                }
                if(i==j || (i+1==j  && i+1 <=n-1)){
                    dp[i][j]=true;
                    if(j-i > end-start){
                        start=i;
                        end=j;
                    }
                    continue;
                }
                if(i+1<=j-1  && i+1 <=n-1){
                    dp[i][j]=dp[i+1][j-1];
                    if(dp[i][j] && j-i > end-start){
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}