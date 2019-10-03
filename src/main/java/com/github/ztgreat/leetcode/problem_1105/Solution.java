package com.github.ztgreat.leetcode.problem_1105;


class Solution {


    public int minHeightShelves(int[][] books, int shelf_width) {

        // 注意题目 按顺序 几个字

        if (books==null){
            return 0;
        }
        int n=books.length;
        int []dp=new int[n];

        for (int i=0;i<n;i++){
            dp[i]=Integer.MAX_VALUE;
        }

        int j=0;
        for (int i=0;i<n;i++){

            if(i==0){
                dp[i]=books[j][1];
                continue;
            }
            j=i;
            int maxHeight=0;
            int width=shelf_width;
            while (j>=0){
                maxHeight=Math.max(maxHeight,books[j][1]);
                width-=books[j][0];
                if(width<0){
                    break;
                }
                if(j==0){
                    dp[i]=Math.min(dp[i],maxHeight);
                }else{
                    dp[i]=Math.min(dp[i],maxHeight+dp[j-1]);
                }
                j--;
            }
        }
        return dp[n-1];
    }

}