class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i = 0 ; i < n ; i++) {
            int next = i + nums[i];
            if(next > n-1) {
                next = n-1;
            }
            for(int j = i + 1 ; j <= next ; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        if(dp[n-1] == Integer.MAX_VALUE) {
            return 0;
        } else {
            return dp[n-1];
        }
    }
}