class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, nums, dp);
    }

    public int helper(int i, int[] nums, int[] dp) {
        if(dp[i] != -1) {
            return dp[i];
        }
        if(i == 0) {
            return nums[0];
        }
        if(i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        int curr = helper(i-2, nums, dp) + nums[i];
        int notCurr = helper(i-1, nums, dp);
        int ans = Math.max(curr, notCurr);
        dp[i] = ans;
        return ans;
    }
}
