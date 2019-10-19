package com.github.ztgreat.leetcode.problem_650;


class Solution {


    // 质数和因子
    public int minSteps(int n) {

        if(n==1){
            return 0;
        }

        boolean[] isPrime = sieveOfEratosthenes(n);

        if(isPrime[n]){
            return n;
        }

        int []dp=new int[n+1];

        for (int i=2;i<=n;i++){

            if(isPrime[i]){
                dp[i]=i;
                continue;
            }
            for (int j=i/2;j>=1;j--){
                if(i%j==0){
                    dp[i]=dp[j]+i/j;
                    break;
                }
            }

        }
        return dp[n];


    }

    /**
     * 运用埃拉托色筛选法筛选出所有小于等于n的质数
     */
    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        //初始化，默认所有都是质数
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        //筛选，将所有质数的倍数都标记为非质数(最初只知道2是质数)
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = 2; j <= n/i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

}