class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++) {
            char c = s.charAt(i);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, i - left + 1);
        }
        if(ans == Integer.MIN_VALUE) {
            return 0;
        }
        return ans;
    }
}
