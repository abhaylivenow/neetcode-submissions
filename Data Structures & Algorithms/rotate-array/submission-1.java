class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //[1,2,3,4,5,6,7,8]
        //[8,7,6,5,4,3,2,1]
        //[5,6,7,8,1,2,3,4]
        if(k > n) {
            k = k % n;
        }
        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
    }

    public void swap(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}