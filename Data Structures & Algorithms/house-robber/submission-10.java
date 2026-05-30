class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 0) {
            return 0;
        }
        if(n <= 1) {
            return nums[n-1];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2 ; i < n ; i++) {
            int curr = dp[i-2] + nums[i];
            int notCurr = dp[i-1];
            dp[i] = Math.max(curr, notCurr);
        }

        return dp[n-1];
    }

    // public int helper(int i, int[] nums, int[] dp) {
    //     if(dp[i] != -1) {
    //         return dp[i];
    //     }
    //     if(i == 0) {
    //         return nums[0];
    //     }
    //     if(i == 1) {
    //         return Math.max(nums[0], nums[1]);
    //     }
    //     int curr = helper(i-2, nums, dp) + nums[i];
    //     int notCurr = helper(i-1, nums, dp);
    //     int ans = Math.max(curr, notCurr);
    //     dp[i] = ans;
    //     return ans;
    // }
}
