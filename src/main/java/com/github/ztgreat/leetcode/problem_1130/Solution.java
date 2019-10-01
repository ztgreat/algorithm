package com.github.ztgreat.leetcode.problem_1130;


class Solution {

    public int mctFromLeafValues(int[] arr) {


        if(arr==null || arr.length==0 ||arr.length==1){
            return 0;
        }
        if(arr.length==2){
            return arr[0]*arr[1];
        }

        int n=arr.length;
        int[][]dp =new int[n][n];


        for (int i=n-1;i>=0;i--){
            for (int j=i;j<n;j++){
                if(i==j){
                    continue;
                }
                if(i+1==j ){
                    dp[i][j]=arr[i]*arr[j];
                    continue;
                }
                for (int k=i;k<j;k++){
                    if(k==i){
                        if(i+1<=n-1  && i+1<=j){
                            dp[i][j]=dp[i+1][j]+arr[i]*getMax(arr,i+1,j);
                        }
                        continue;
                    }
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+getMax(arr,i,k)*getMax(arr,k+1,j));
                }
            }
        }
        return dp[0][n-1];
    }

    public  int getMax(int [] arr,int x,int y){

        if(x>y){
            return 0;
        }
        int max=-1;
        for (int i=x;i<=y  && i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}