class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int ans = 0;
        int min = 1;
        for(int wei : weights) {
            min = Math.max(wei, min);
            max += wei;
        }
        ans = max;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(canShip(weights, days, mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    public boolean canShip(int[] weights, int days, int limit) {
        int day = 1;
        int n = weights.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            if(sum + weights[i] > limit) {
                day++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        if(day <= days) {
            return true;
        } else {
            return false;
        }
    }
}