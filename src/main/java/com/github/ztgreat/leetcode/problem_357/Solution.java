package com.github.ztgreat.leetcode.problem_357;


class Solution {


    // 方法1 每个位置上的数 都要不一样，排列组合
    public  int countNumbersWithUniqueDigits(int n) {


        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int ans=10;
        int cnt;
        int mul;
        for (int i=2;i<=n;i++){

            mul=9;
            cnt=9;
            for (int j=2;j<=i;j++){
                mul*=cnt;
                cnt--;
            }
            ans+=mul;
        }

        return ans;

    }

    // 方法2
    public  int countNumbersWithUniqueDigits2(int n) {


        //dp[i]=dp[i-1]*(10-i+1);  dp[i] 表示 i 位数字的 各位不同数字的个数
        //最终结果：ans=10+dp[2]+dp[3]+..+dp[n];

        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int[] dp=new int[n+1];
        dp[1]=9;
        int ans=10;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]*(10-i+1);
            ans+=dp[i];
        }
        return ans;

    }

}