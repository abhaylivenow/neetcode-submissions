class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] postProduct = new int[n];
        int[] preProduct = new int[n];
        postProduct[n-1] = nums[n-1];
        preProduct[0] = nums[0];

        for(int i = 1 ; i < n ; i++) {
            preProduct[i] = nums[i] * preProduct[i-1];
        }

        for(int i = n-2 ; i >= 0 ; i--) {
            //System.out.println(nums[i] + ","+postProduct[i+1]);
            postProduct[i] = nums[i] * postProduct[i+1];
        }

        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++) {
            if(i == 0) {
                ans[i] = postProduct[i+1];
            } else if(i == n-1) {
                ans[i] = preProduct[n-2];
            } else {
                ans[i] = preProduct[i-1] * postProduct[i+1];
            }
        }

        return ans;
    }
}  
