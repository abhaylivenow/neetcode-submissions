class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] table = new int[n];

        for(int i = 0 ; i < n ; i++) {
            table[i] = nums[i];
        }
        table[0] = nums[0];

        int ans = 0;
        for(int i = 1 ; i < n ; i++) {
            if(i == 1) {
                table[i] = Math.max(table[i-1], table[i]);
            } else {
                table[i] = Math.max(table[i-1], table[i-2] + table[i]);
            }
        }
        for(int i = 0 ; i < n ; i++) {
            ans = Math.max(ans, table[i]);
        }
        return ans;
    }
}
