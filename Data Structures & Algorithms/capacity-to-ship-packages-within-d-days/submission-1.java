class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int sum = 0;
        for(int wei : weights) {
            min = Math.max(min, wei);
            sum += wei;
        }

        int l = min;
        int r = sum;
        int ans = 0;

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(canShip(weights, mid, days)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean canShip(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int shipped = 0;

        for(int wei : weights) {
            if(shipped + wei > capacity) {
                daysNeeded++;
                shipped = wei;
            } else {
                shipped += wei;
            }
        }

        return daysNeeded <= days;
    }
}