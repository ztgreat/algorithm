package com.github.ztgreat.leetcode.problem_646;


import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int findLongestChain(int[][] pairs) {


        int n = pairs.length;
        if(n==1){
            return 1;
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int [] dp = new int[n];
        int ans=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(ans<dp[i]){
                ans=dp[i];
            }
        }
        if(ans>=1){
            return ans+1;
        }
        return 1;

    }


}