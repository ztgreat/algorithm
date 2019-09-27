package com.github.ztgreat.leetcode.problem_303;


class NumArray {

    public int [] dp;
    public NumArray(int[] nums) {
        this.dp=new int[nums.length+1];

        if(nums.length==0){
            dp[0]=0;
        }else{
            dp[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                dp[i]=dp[i-1]+nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {

        if(i==0){
            return dp[j];
        }
        return this.dp[j]-dp[i-1];

    }
}

//解法 1
//class NumArray {
//
//    public int [] nums;
//    public NumArray(int[] nums) {
//        this.nums=nums;
//    }
//
//    public int sumRange(int i, int j) {
//
//        int sum=0;
//        for(int m=i;m<=j;m++){
//            sum+=this.nums[m];
//        }
//        return sum;
//
//    }
//}