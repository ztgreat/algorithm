package com.github.ztgreat.dp.leetcode_494;


class Solution2 {


    /**
     * 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
     * <p>
     * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     * <p>
     * 那么让我们看看如何将其转换为子集求和问题：
     * <p>
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     * <p>
     * 因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
     * <p>
     * 请注意，上面的公式已经证明target + sum(nums)必须是偶数，否则输出为0
     */

    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < S || ((S + sum) & 1) == 1) {
            return 0;
        }

        int cur = (S + sum) >>> 1;

        // dp[i][j] 表示 前i 个 数 选 出来 和 等于 j
        int[][] dp = new int[n + 1][cur + 1];

        if (nums[0] == 0) {
            // 选 和 不选 是两种方案 都可以,因此这里 是2
            dp[0][0] = 2;
        } else {
            // 只能不选
            dp[0][0] = 1;
        }
        for (int j = 1; j <= cur; j++) {
            dp[0][j] = (nums[0] == j ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= cur; j++) {
                if (j >= nums[i]) {
                    // 选 nums[i]
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
                // 不选 nums[i]
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[n - 1][cur];
    }

    // 一维数组 版本
    public int findTargetSumWays2(int[] nums, int S) {

        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < S || ((S + sum) & 1) == 1) {
            return 0;
        }

        int cur = (S + sum) >> 1;
        int[] dp = new int[cur + 1];
        dp[0] = 1;
        if (nums[0] == 0) {
            dp[0] = 2;
        }
        for (int j = 1; j <= cur; j++) {
            dp[j] = nums[0] == j ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = cur; j >= 0; j--) {
                if (j >= nums[i]) {
                    //注意 这里 dp[j]= dp[j]+dp[j-num[i]]
                    // 不选 num[i] 和选 num[i]
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[cur];

    }


}