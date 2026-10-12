class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int l = 0;
        int r = n-1;
        Arrays.sort(people);
        int boat = 0;

        while(l <= r) {
            if(people[r] >= limit) {
                boat++;
                r--;
            } else if(people[r] + people[l] == limit || people[r] + people[l] < limit) {
                boat++;
                l++;
                r--;
            } else if(people[r] + people[l] > limit && people[r] < limit) {
                boat++;
                r--;
            } else {
                l++;
            }
        }
        return boat;
    }
}