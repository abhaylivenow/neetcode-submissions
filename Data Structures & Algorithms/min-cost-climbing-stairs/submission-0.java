class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2 ; i < n ; i++) {
            int fromOneLast = dp[i-1] + cost[i];
            int fromTwoLast = dp[i-2] + cost[i];
            dp[i] = Math.min(fromOneLast, fromTwoLast);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}
