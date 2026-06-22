class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int st = 0;
        for(int num : stones) {
            st += num;
        }
        boolean[][] dp = new boolean[n+1][st+1];
        for(int i = 0 ; i <= n ; i++) {
            dp[i][0] = true;
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int sum = 0 ; sum <= st ; sum ++) {

                boolean noPick = dp[i-1][sum];
                boolean pick = false;
                if(sum >= stones[i-1]) {
                    pick = dp[i-1][sum - stones[i-1]];
                }

                dp[i][sum] = noPick || pick;
            }
        }
        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i <= st/2 ; i++) {
            if(dp[n][i]) {
                ans = Math.min(ans, Math.abs(st - 2*i));
            }
        }
        return ans;

        //return helper(0, 0, stones, st, dp);
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