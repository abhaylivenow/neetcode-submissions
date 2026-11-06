class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;

        int index = 0;
        int[] ans = new int[n-k+1];
        int left = 0;
        for(int i = 0 ; i < n ; i++) {
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i >= k-1) {
                ans[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return ans;
    }
}
