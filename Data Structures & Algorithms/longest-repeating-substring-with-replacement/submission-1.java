class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for(int i = 0 ; i < n ; i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
                maxFreq = Math.max(map.get(c), maxFreq);
            } else {
                map.put(c, 1);
                maxFreq = Math.max(1, maxFreq);
            }
            
            while(i-left+1 - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            
            ans = Math.max(ans, i - left + 1);
        }
    
        return ans;
    }
}
