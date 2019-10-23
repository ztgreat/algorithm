package com.github.ztgreat.dp.leetcode_688;


import java.util.LinkedList;

class Solution {


    // dp
    public double knightProbability2(int N, int K, int r, int c) {

        // dp[r][c][steps] 代表马在位置 (r, c) 移动了 steps 次以后还留在棋盘上的概率
        double[][][] dp = new double[N][N][K + 1];
        int[][] step = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int s = 0; s < 8; s++) {
                        int newI = i + step[s][0];
                        int newJ = j + step[s][1];
                        if (newI >= 0 && newI < N && newJ >= 0 && newJ < N) {
                            dp[i][j][k] += dp[newI][newJ][k - 1] / 8;
                        }
                    }
                }
            }
        }
        return dp[r][c][K];

    }

    // 记忆化 dfs
    double[][][] dfsDp;
    int[][] stepDfs = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

    public double knightProbability3(int N, int K, int r, int c) {

        if (K == 0) {
            return 1;
        }
        dfsDp = new double[N][N][K + 1];
        return dfs(N, K, r, c);

    }

    public double dfs(int N, int k, int r, int c) {

        if (k == 0) {
            return 1;
        }
        if (dfsDp[r][c][k] != 0) {
            return dfsDp[r][c][k];
        }
        double res = 0;
        for (int s = 0; s < 8; s++) {
            int newI = r + stepDfs[s][0];
            int newJ = c + stepDfs[s][1];
            if (newI >= 0 && newI < N && newJ >= 0 && newJ < N) {
                res += dfs(N, k - 1, newI, newJ) / 8;
            }
        }
        dfsDp[r][c][k] = res;
        return dfsDp[r][c][k];

    }


    // bfs  超时
    public double knightProbability(int N, int K, int r, int c) {


        int[][] step = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(new Node(r, c, K, 1));
        double ans = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.i >= 0 && node.i < N && node.j >= 0 && node.j < N && node.k == 0) {
                ans += node.ans;
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int newI = node.i + step[i][0];
                int newJ = node.j + step[i][1];
                if (newI >= 0 && newI < N && newJ >= 0 && newJ < N) {
                    queue.addLast(new Node(newI, newJ, node.k - 1, node.ans / 8));
                }
            }
        }
        return ans;
    }

    class Node {
        int i;
        int j;
        int k;

        double ans;

        public Node(int i, int j, int k, double ans) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.ans = ans;
        }
    }


}