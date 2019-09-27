package com.github.ztgreat.leetcode.problem_392;


class Solution {

    public boolean isSubsequence(String s, String t) {

       if(s==null || "".equals(s)){
           return true;
       }
       if(t == null || "".equals(t)){
           return false;
       }

       int i=s.length()-1;
       int j=t.length()-1;

       while (i>=0  && j>=0){

           if(s.charAt(i)==t.charAt(j)){
               i--;
               j--;
               continue;
           }
           j--;
       }
        return i == -1;
    }

// 方法2
//    public boolean isSubsequence(String s, String t) {
//
//        boolean [][] dp = new boolean[s.length()+1][t.length()+1];
//
//        if(s.length()==0){
//            return true;
//        }
//        if(t.length()==0){
//            return false;
//        }
//        for (int i=0;i<s.length();i++){
//            for (int j=0;j<t.length();j++){
//                if(s.charAt(i)==t.charAt(j)){
//                    if(i==0 || j==0){
//                        dp[i][j]=true;
//                    }else{
//
//                        dp[i][j]=dp[i-1][j-1];
//                    }
//                }else{
//                    if(j==0){
//                        dp[i][j]=false;
//                    }else{
//                        dp[i][j]=dp[i][j-1];
//                    }
//                }
//            }
//        }
//        return dp[s.length()-1][t.length()-1];
//
//    }
}