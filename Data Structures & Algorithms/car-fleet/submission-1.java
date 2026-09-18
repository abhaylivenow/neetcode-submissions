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
        Map<Integer, Double> map = new HashMap<>();
        int n = speed.length;
        double[] time = new double[n];

        for(int i = 0 ; i < n ; i++) {
            int rem = target - position[i];
            double timeRequired = (double)rem / speed[i];

            time[i] = timeRequired;
            map.put(position[i], timeRequired);
        }
        Map<Integer, Double> decreasingMap = new TreeMap<>(Collections.reverseOrder());
        decreasingMap.putAll(map);

        List<Pair> list = new ArrayList<>();
        for(int key : decreasingMap.keySet()) {
            list.add(new Pair(key, decreasingMap.get(key)));
        }
        double fleetTimeAhead = list.get(0).second;
        int ans = 1;

        for(int i = 1 ; i < n ; i++) {
            if(list.get(i).second <= fleetTimeAhead) {
                // might not need to do anything
            } else if(list.get(i).second > fleetTimeAhead) {
                ans++;
                fleetTimeAhead = list.get(i).second;
            }
        }

        return ans;
    }
}
