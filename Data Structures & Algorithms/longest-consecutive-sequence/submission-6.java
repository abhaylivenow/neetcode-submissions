class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        int ans = 1;
        for(int num : set) {
            int count = 1;
            if(!set.contains(num-1)) {
                int toCheck = num+1;
                while(set.contains(toCheck)) {
                    count++;
                    toCheck++;
                    ans = Math.max(count, ans);
                }
            }
        }

        return ans;
    }
}