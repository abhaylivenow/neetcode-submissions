class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = n-1;
            while(l < r) {
                int res = nums[i] + nums[l] + nums[r];
                if(res == 0) {
                    List<Integer> miniList = new ArrayList<>();
                    miniList.add(nums[i]);
                    miniList.add(nums[l]);
                    miniList.add(nums[r]);
                    l++;
                    r--;
                    ans.add(miniList);

                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(l < r && nums[r] == nums[r+1]) r--;
                } else if(res < 0) {
                    l++;
                } else r--;
            }
        }
        return ans;
    }
}
