class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] arrR = new int[n];
        int[] arrL = new int[n];

        int tempLeft = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++) {
            if(height[i] > tempLeft) {
                tempLeft = height[i];
            }
            arrL[i] = tempLeft;
        }
        
        int tempRight = Integer.MIN_VALUE;
        for(int i = n-1 ; i >= 0; i--) {
            if(height[i] > tempRight) {
                tempRight = height[i];
            }
            arrR[i] = tempRight;
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            ans += Math.min(arrL[i], arrR[i]) - height[i];
        }
        return ans;
    }
}
