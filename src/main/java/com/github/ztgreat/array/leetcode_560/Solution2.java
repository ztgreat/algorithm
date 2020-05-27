package com.github.ztgreat.array.leetcode_560;


import java.util.HashMap;

class Solution2 {

    public int subarraySum(int[] nums, int k) {

        if (nums == null) {
            return 0;
        }

        // pre[i]-pre[j]==k  -> pre[i]-k == pre[j]

        HashMap<Integer, Integer> map = new HashMap<>();
        // 和为0 ,一个元素也不选，是一种方案
        map.put(0, 1);
        int pre = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }


}