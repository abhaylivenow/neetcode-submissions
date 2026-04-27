class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int ans = 1;
        for(int num: nums) {
            int count = 1;
            int toCheck = num+1;
            while(set.contains(toCheck)) {
                count++;
                ans = Math.max(ans,count);
                toCheck++;
            }
        }
        return ans;
    }
}
