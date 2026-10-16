class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int max = Integer.MIN_VALUE;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        int r = max;
        int ans = 0;

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(canEat(mid, piles, h)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEat(int k, int[] piles, int h) {
        int timeTaken = 0;
        for(int pile : piles) {
            timeTaken += Math.ceil((double)pile / k);
        }

        return timeTaken <= h;
    }
}
