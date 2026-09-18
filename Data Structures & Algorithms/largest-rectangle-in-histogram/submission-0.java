class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = Integer.MIN_VALUE;
        int[] nSmaller = nextSmaller(heights);
        int[] pSmaller = prevSmaller(heights);

        for(int i = 0 ; i < n ; i++) {
            int ns = nSmaller[i];
            int ps = pSmaller[i];
            int w = ns - ps - 1;
            int h = heights[i];
            area = Math.max(area, w * h);
        }
        return area;
    }

    public int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = n - 1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

    public int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }
}
