package com.github.ztgreat.leetcode.problem_1024;


class Solution {


    // 方法1
    public int videoStitching(int[][] clips, int T) {


        // dp[i][j]  表示  视频i到j 需要最少的片段
        int [][]dp=new int[T+1][T+1];
        for (int i=0;i<=T;i++){
            for (int j=0;j<=T;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        int max=0;
        for (int i=0;i<clips.length;i++){

            if(max<clips[i][1]){
                max=clips[i][1];
            }
            for (int j=clips[i][0];j<=clips[i][1];j++){
                dp[Math.min(j,T)][Math.min(clips[i][1], T)]=1;
                dp[Math.min(clips[i][0], T)][Math.min(j,T)]=1;
            }
        }

        if(T>max){
            return -1;
        }

        for (int i=T;i>=0;i--){
            for (int j=i+1;j<=T;j++){
                if(dp[i][j]==1){
                    continue;
                }
                for (int k=i+1;k<j;k++){
                    if(dp[i][k]==Integer.MAX_VALUE || dp[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        return dp[0][T]==Integer.MAX_VALUE?-1:dp[0][T];
    }

    // 方法2
    public int videoStitching2(int[][] clips, int T) {


        // dp[i] 表示 视频 0-i 最少需要的片段
        // dp[i]=Math.min(dp[i],dp[clips[j][0]]+1)  && dp[clips[j][0]] 可以拼成
        int []dp = new int[101];

        for (int i=1;i<=T;i++){
            for (int j=0;j<clips.length;j++){
                if(clips[j][0]<=i  && clips[j][1]>=i){

                    if(clips[j][0]==0 ){
                        dp[i]=1;
                        continue;
                    }
                    if(dp[clips[j][0]]==0){
                        continue;
                    }
                    if(dp[i]==0){
                        dp[i]=dp[clips[j][0]]+1;
                        continue;
                    }
                    dp[i]=Math.min(dp[i],dp[clips[j][0]]+1);
                }
            }
        }
        if(dp[T]==0){
            return -1;
        }
        return dp[T];

    }

}