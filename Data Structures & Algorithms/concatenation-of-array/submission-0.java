class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        if(n == 0) return nums;
        int[] ans = new int[2*n];

        for(int i = 0 ; i < 2*n ; i++) {
            int newValidIndex = i % n;
            ans[i] = nums[newValidIndex];
        }
        return ans;
    }
}