class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int num : nums) {
            if(map.containsKey(num)) {
                int val = map.get(num) + 1;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }

        for(int key : map.keySet()) {
            if(map.get(key) > n/3) {
                ans.add(key);
            }
        }

        return ans;
    }
}