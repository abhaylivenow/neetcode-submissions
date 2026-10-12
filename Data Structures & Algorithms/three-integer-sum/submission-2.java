class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0 ; i < n ; i++) {
            if(i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            
            int l = i+1;
            int r = n-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    List<Integer> miniList = new ArrayList<>();
                    miniList.add(nums[i]);
                    miniList.add(nums[l]);
                    miniList.add(nums[r]);
                    ans.add(miniList);
                    l++;
                    r--;

                    while(l < n && nums[l-1] == nums[l]) {
                        l++;
                    }
                    while(r >= 0 && nums[r+1] == nums[r]) {
                        r--;
                    }
                } else if(sum < 0) {
                    l++;
                } else {
                    r--;
                }   
            }
        }

        return ans;
    }
}
