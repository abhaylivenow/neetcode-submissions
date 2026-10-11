class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prevSum = 0;
        int count = 0;

        for(int num : nums) {
            prevSum += num;

            if(map.containsKey(prevSum - k)) {
                count += map.get(prevSum - k);
            }

            if(map.containsKey(prevSum)) {
                map.put(prevSum, map.get(prevSum)+1);
            } else {
                map.put(prevSum, 1);
            }
        }
        return count;
    }
}