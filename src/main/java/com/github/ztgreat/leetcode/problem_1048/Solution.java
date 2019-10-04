package com.github.ztgreat.leetcode.problem_1048;


import java.util.Arrays;
import java.util.Comparator;

class Solution {




    public int longestStrChain(String[] words) {


        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int n = words.length;
        int []dp = new int [n];
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                //判断 第i个单词 和 j个单词 是否可以
                if(checke(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        for (int i=0;i<n;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max+1;
    }

    boolean checke(String a,String b){


        if(a.length()+1!= b.length()){
            return false;
        }
        boolean flag;
        for (int i=0;i<a.length();i++){
            flag=true;
            for (int j=0;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return false;
            }
        }
        return true;
    }
}