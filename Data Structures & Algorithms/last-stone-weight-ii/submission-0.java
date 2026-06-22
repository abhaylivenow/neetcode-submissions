class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int st = 0;
        for(int num : stones) {
            st += num;
        }
        int[][] dp = new int[n+1][st+1];
        for(int i = 0 ; i < n ; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, stones, st, dp);
    }

    public int helper(int index, int sum, int[] stones, int st, int[][] dp) {
        int n = stones.length;
        
        if(index == n) {
            dp[index][sum] = Math.abs(st - 2 * sum);
            return Math.abs(st - 2 * sum);
        }
        if(dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int notPick = helper(index + 1, sum, stones, st, dp);
        int pick = 0;
        pick = helper(index + 1, sum + stones[index], stones, st, dp);

        dp[index][sum] = Math.min(notPick, pick);
        return Math.min(notPick, pick);
    }
}