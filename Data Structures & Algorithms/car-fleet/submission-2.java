class Solution {

    class Pair {
        int first;
        double second;

        public Pair(int f, double s) {
            first = f;
            second = s;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Pair> listOfPair = new ArrayList<>();

        Map<Integer, Double> map = new HashMap<>();
        // time needed to reach -> list of cars starting position

        for(int i = 0 ; i < n ; i++) {
            int currSpeed = speed[i];
            int dist = target - position[i];
            double time = (double)dist / currSpeed;

            map.put(position[i], time);
        }

        int ans = 1;

        for(int key : map.keySet()) {
            listOfPair.add(new Pair(key, map.get(key)));
        }
        listOfPair.sort((a, b) -> Integer.compare(b.first, a.first));

        double fleetTimeAhead = listOfPair.get(0).second;

        for(int i = 1 ; i < n ; i++) {
            if(listOfPair.get(i).second > fleetTimeAhead) {
                ans++;
                fleetTimeAhead = listOfPair.get(i).second;
            }
        }
        return ans;
    }
}
