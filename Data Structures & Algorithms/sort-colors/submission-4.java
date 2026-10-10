class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zPos = 0;
        int pos2 = n-1;
        int i = 0;
        while(i <= pos2) {
            if(nums[i] == 0) {
                int temp = nums[zPos];
                nums[zPos] = nums[i];
                nums[i] = temp;
                zPos++;
                i++;
            } else if(nums[i] == 2) {
                int temp = nums[pos2];
                nums[pos2] = nums[i];
                nums[i] = temp;
                pos2--;
            } else {
                i++;
            }
        }

    }
}