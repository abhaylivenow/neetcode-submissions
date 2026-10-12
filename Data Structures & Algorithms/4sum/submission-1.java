class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            if(i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int subTarget = target - nums[i];
            List<List<Integer>> getThreeSum = isThreeSumValid(nums, subTarget, i+1);
            
            for(List<Integer> list : getThreeSum) {
                if(list.size() == 3) {
                    List<Integer> miniList = new ArrayList<>();
                    miniList.addAll(list);
                    miniList.add(nums[i]);
                    ans.add(miniList);
                }
            }

        }

        return ans;
    }

    public List<List<Integer>> isThreeSumValid(int[] nums, int target, int startIndex) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = startIndex ; i < n ; i++) {
            if(i > startIndex && nums[i-1] == nums[i]) {
                continue;
            }

            int l = i+1;
            int r = n-1;

            while(l < r) {
                long sum = (long) nums[i] + nums[r] + nums[l];
                if(sum == (long)target) {
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
                } else if(sum < (long)target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}