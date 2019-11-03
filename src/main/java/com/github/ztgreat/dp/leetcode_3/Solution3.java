package com.github.ztgreat.dp.leetcode_3;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 官方题解
 * 优化的滑动窗口
 * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
 * <p>
 * 也就是说，如果 s[j] 在 [i, j) 范围内有与 j'
 * 重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1
 */
class Solution3 {


    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(n);
        int ans = 1;
        for (int j = 0, i = 0; j < n; j++) {

            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


}