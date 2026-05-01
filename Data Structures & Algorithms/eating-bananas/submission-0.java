class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int num : piles) {
            if(num > max) {
                max = num;
            }
        }

        int min = 1;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(canEat(piles, mid, h)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid+1;
            }
        }
        return ans;
    }

    public boolean canEat(int[] piles, int speed, int k) {
        int timeTaken = 0;
        for(int pile : piles) {
            timeTaken += Math.ceil((double)pile / speed);
        }
        return timeTaken <= k;
    }
}
