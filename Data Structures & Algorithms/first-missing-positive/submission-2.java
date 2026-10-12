class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i < n) {
            int correctIndex = nums[i] - 1;
            if(nums[i] < n && nums[i] > 0 && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for(int j = 0 ; j < n ; j++) {
            if(nums[j] != j+1) {
                return j+1;
            }
        }

        return nums[n-1]+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}