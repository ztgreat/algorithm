package com.github.ztgreat.leetcode.problem_96;


class Solution {

    // 方法1
    public int numTrees(int n) {


        int [][]dp = new int [n+1][n+1];

        //序列 i~j 中，枚举 根节点k
        //dp[i][j]=dp[i][k-1]*dp[k+1][j];

        for (int i=n;i>=1;i--){
            for (int j=i;j<=n;j++){

                if(i==j){
                    dp[i][j]=1;
                    continue;
                }
                if(i+1==j){
                    dp[i][j]=2;
                    continue;
                }
                for (int k=i;k<=j;k++){

                    if(i==k){
                        dp[i][j]+=dp[k+1][j];
                        continue;
                    }
                    if(k==j){
                        dp[i][j]+=dp[i][k-1];
                        continue;
                    }

                    dp[i][j]+=dp[i][k-1]*dp[k+1][j];
                }
            }
        }
        return dp[1][n];
    }

    // 方法2
    public int numTrees2(int n) {

        // n 个数 构成的 搜索树 个数 为 f(n);

        //f(n)=p(1)+p(2)+p(3)+...+p(n);
        //p(i) 表示 以i 为根节点的 搜索树的个数

        //p(i)=f(i-1)*f(n-i),i-1 是左子树 包含的节点，n-i 表示 右子树 包含的节点

        //f(n)=(求和)f(i-1)*f(n-i)  (i=1,2,3,4...n)

        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }

}