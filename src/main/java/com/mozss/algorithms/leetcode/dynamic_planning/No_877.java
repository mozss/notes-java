package com.mozss.algorithms.leetcode.dynamic_planning;

/**
 * @author mozss
 * @create 2019-09-04 23:05
 */


/*
*
*题目描述：
亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中
* 石子最多的玩家获胜。
假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。


示例：
输入：[5,3,4,5]
输出：true
解释：
亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
* */


public class No_877 {

    /*
     * 方法一：动态规划
     *
     * 思路：让我们改变规则，每当李得分就会从亚历克斯的分数扣除
     * 令dp(i,j)为亚历克斯可以获得的最大分数，其中剩下的堆中的石子数是piles[i],piles[i+1]，...,piles[
     *
     * 我们根据dp(i+1,j)和dp(i,j-1)来制定dp(i,j)的递归，我们可以使用动态编程以不重复这个递归
     * 中的工作，该方法可以输出正确的答案，因为状态形成一个DGA（动态无向图）
     *
     * 算法：
     * 当剩下的堆的石子数是piles[i],piles[i+1],...,piles[j]时，轮到的玩家最多有2种行为
     *
     * 可以通过比较j-1和N moudulo 2来找到轮到的人。
     *
     * 如果玩家是亚历克斯，那么她将取走piles[i]或者piles[j]颗石子，增加她的分数，之后，总数为piple[i]或者piles[j]颗石子，增加她
     * 的分数。之后，总分为piles[i]+dp(i+1,j)或者piles[j]+dp(i,j-1)；我们想要其中的最大可能得分。
     *
     * 如果玩家是李，那么他将取走piles[i]或者piles[j]颗石子，减少亚历克斯这一数量的分数。之后，总分为-piles[i] + dp(i+1,j)
     * 或者-piles[j] + dp(i, j-1)
     * 我们想要其中的最小可能得分。
     *
     * */

    public boolean stoneGame(int[] piles) {
        int N = piles.length;

        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; ++size) {
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;
                if (parity == 1)
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                else
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
            }
        }
        return dp[0][N] > 0;
    }

}