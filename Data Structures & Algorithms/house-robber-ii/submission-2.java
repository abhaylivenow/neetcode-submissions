class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n-1), robRange(nums, 1, n));
    }

    public int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int[] table = new int[n];

        for(int i = start ; i < end ; i++) {
            table[i] = nums[i];
        }
        table[start] = nums[start];

        int ans = 0;
        for(int i = start+1 ; i < end ; i++) {
            if(i == start+1) {
                table[i] = Math.max(table[i-1], table[i]);
            } else {
                table[i] = Math.max(table[i-1], table[i-2] + table[i]);
            }
            ans = Math.max(ans, table[i]);
        }
        for(int i = start ; i < end ; i++) {
            ans = Math.max(ans, table[i]);
        }
        return ans;
    }
}
