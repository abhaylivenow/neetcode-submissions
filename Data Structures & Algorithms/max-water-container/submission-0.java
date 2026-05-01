class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;

        int area = Integer.MIN_VALUE;
        int ans = 0;

        while(i < j) {
            int l = Math.min(heights[i], heights[j]);
            int b = j - i;
            area = l*b;
            ans = Math.max(ans, area);

            if(heights[i] > heights[j]) {
                j--;
            } else i++;
        }

        return ans;
    }
}
