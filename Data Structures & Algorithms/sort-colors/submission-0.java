class Solution {
    public void sortColors(int[] nums) {
        int positionZero = 0;
        int positionOne = 0;
        int positionTwo = 0;
        int n = nums.length;

        for(int i = 0; i < n ; i++) {
            if(nums[i] == 0) {
                positionZero++;
            }
            if(nums[i] == 1) {
                positionOne++;
            }
            if(nums[i] == 2) {
                positionTwo++;
            }
        }

        int pos = 0;
        while(pos < positionZero) {
            nums[pos] = 0;
            pos++;
        }
        while(pos < positionZero+positionOne) {
            nums[pos] = 1;
            pos++;
        }
        while(pos < positionZero+positionOne+positionTwo) {
            nums[pos] = 2;
            pos++;
        }
    }
}