class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < n ; i++) {
            while(!valid(x, arr[left], arr[i]) && (i - left + 1 > k)) {
                left++;
            }

            if(i - left + 1 == k) {
                end = i;
                start = left;
            }
        }
        for(int i = start ; i < end+1 ; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public boolean valid(int x, int a, int b) {
        if((Math.abs(a-x) <= Math.abs(b - x)) && a < b) {
            return true;
        } else {
            return false;
        }
    }

}