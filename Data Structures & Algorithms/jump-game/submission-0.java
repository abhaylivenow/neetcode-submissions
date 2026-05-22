class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 0 ; i < n ; i++) {
            if(dp[i] == true) {
                int next = i + nums[i];
                if(next > n-1) {
                    next = n - 1;
                }
                for(int j = i+1 ; j <= next ; j++) {
                    dp[j] = true;
                }
            }
        }

        return dp[n-1];
    }
}