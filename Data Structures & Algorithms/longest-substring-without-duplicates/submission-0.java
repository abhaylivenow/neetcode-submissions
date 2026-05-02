class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            char c = s.charAt(i);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
