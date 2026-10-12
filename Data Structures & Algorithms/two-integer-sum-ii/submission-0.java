class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n-1;
        int[] ans = new int[2];

        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                ans[0] = i+1;
                ans[1] = j+1;
                i++;
                j--;
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
