package com.github.ztgreat.leetcode.problem_1027;


import java.util.HashMap;

class Solution {


    public int longestArithSeqLength(int[] A) {


        int n=A.length;
        int[]dp =new int[n];
        // 记录公差信息
        HashMap<Integer,HashMap<Integer,Integer>>map =new HashMap<>();

        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if(j==0){
                    dp[i]=2;
                    HashMap m= new HashMap(i+1);
                    m.put(A[i]-A[j],2);
                    map.put(i,m);
                    continue;
                }
                Integer s= map.get(j).get(A[i]-A[j]);
                if(s!=null){
                    dp[i]=Math.max(dp[i],s+1);
                    Integer t=map.get(i).get(A[i] - A[j]);
                    if(t==null || t < dp[i]){
                        map.get(i).put(A[i]-A[j],s+1);
                    }
                }else{
                    dp[i]=Math.max(dp[i],2);
                    Integer t=map.get(i).get(A[i] - A[j]);
                    if(t==null || t < dp[i]){
                        map.get(i).put(A[i]-A[j],2);
                    }
                }

            }
        }

        int max=0;
        for (int i=0;i<n;i++){

            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;

    }

    public static void main(String[] args){

        int []a={6,17,42,48,28,14};

        new Solution().longestArithSeqLength(a);

    }

}