class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(dp[i][j] != 1) {
                    dp[i][j] = -1;
                }
            }
        }
        return helper(n-1, m-1, obstacleGrid, dp);
    }

    public int helper(int i, int j, int[][] grid, int[][] dp) {
        
        
        if(i < 0 || j < 0 || grid[i][j] == 1) {
            return 0;
        }
        if(i == 0 && j == 0) {
            return 1;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ways = helper(i-1, j, grid, dp) + helper(i, j-1, grid, dp);
        dp[i][j] = ways;

        return ways;
    }
}