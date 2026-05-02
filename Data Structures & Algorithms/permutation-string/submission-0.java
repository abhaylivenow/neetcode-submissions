class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        for(int i = 0 ; i < s1.length() ; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int[] s2Arr = new int[26];

        for(int right = 0 ; right < s2.length() ; right++) {
            char c = s2.charAt(right);
            while(right - left + 1 > s1.length()) {
                s2Arr[s2.charAt(left) - 'a']--;
                left++;
            }
            s2Arr[c - 'a']++;
            if(right - left + 1 == s1.length()) {
                if(Arrays.equals(s1Arr, s2Arr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
