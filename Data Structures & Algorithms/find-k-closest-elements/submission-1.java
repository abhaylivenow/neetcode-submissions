class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0;
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            while(!isValid(x, arr[left],arr[i]) && i - left + 1 > k) {
                left++;
            }
            if(i-left+1 == k) {
                start = left;
                end = i;
            }
        }
        for(int j = start ; j <= end ; j++) {
            ans.add(arr[j]);
        }
        return ans;
    }

    public boolean isValid(int x, int a, int b) {
        if(Math.abs(a-x) < Math.abs(b-x) || (Math.abs(a-x) == Math.abs(b-x) && a < b)) {
            return true;
        } else {
            return false;
        }
    }
}