package com.github.ztgreat.dp.leetcode_279;


import java.util.LinkedList;

class Solution2 {


    public int numSquares(int n) {

        // bfs

        //bfs队列
        LinkedList<LinkedList<Integer>> queues = new LinkedList<>();

        //访问标记
        boolean[] vis = new boolean[n + 1];
        int cnt = 0;

        // 使用两个循环队列来处理,节约内存
        queues.addLast(new LinkedList<>());
        queues.addLast(new LinkedList<>());
        for (int i = 1; i * i <= n; i++) {
            queues.get(0).addLast(n - i * i);
        }
        cnt++;
        int cal;
        while (true) {
            LinkedList<Integer> queue = queues.get(0);
            while (!queue.isEmpty()) {
                int temp = queue.pop();
                if (temp == 0) {
                    return cnt;
                }
                for (int i = temp > 2 ? temp / 2 : temp; i > 0; i--) {
                    if ((cal = i * i) > temp) {
                        continue;
                    }
                    if (vis[temp - cal]) {
                        continue;
                    }
                    vis[temp - cal] = true;
                    queues.get(1).addLast(temp - cal);
                }
            }
            cnt++;
            queues.removeFirst();
            queue.clear();
            queues.addLast(queue);
        }
    }

}