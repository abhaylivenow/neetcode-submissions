class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r) {
            
            int mid = l + (r-l)/2;

            if(nums[mid] == target) {
                return true;
            }

            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if(nums[l] <= nums[mid]) { // left half is sorted
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // right half is sorted
                if(nums[r] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}