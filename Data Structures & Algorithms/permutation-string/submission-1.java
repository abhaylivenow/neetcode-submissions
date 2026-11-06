class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        Arrays.fill(s1Arr, 0);
        Arrays.fill(s2Arr, 0);
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) {
            return false;
        }

        for(char c : s1.toCharArray()) {
            s1Arr[c-'a']++;
        }
        
        int left = 0;

        for(int i = 0 ; i < n2 ; i++) {
            char c = s2.charAt(i);
            while(i - left + 1 > n1) {
                s2Arr[s2.charAt(left) - 'a']--;
                left++;
            }
            s2Arr[c - 'a']++;

            if(Arrays.equals(s1Arr, s2Arr)) {
                    return true;
            }
        }
        return false;
    }
}
