class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(n-1, m-1, grid, dp);
    }

    public int helper(int i, int j, int[][] grid, int[][] dp) {
        
        if(i == 0 && j == 0) {
            return grid[0][0];
        }

        if(i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = helper(i-1, j, grid, dp);
        if(up != Integer.MAX_VALUE) {
            up += grid[i][j];
        }

        int left = helper(i, j-1, grid, dp);
        if(left != Integer.MAX_VALUE) {
            left += grid[i][j];
        }

        int ans = Math.min(left, up);
        dp[i][j] = ans;

        return ans;
    }
}