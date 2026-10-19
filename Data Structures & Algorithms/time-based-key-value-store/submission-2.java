class TimeMap {

    class Pair {
        int timeStamp;
        String value;

        public Pair(int t, String v) {
            timeStamp = t;
            value = v;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);

        if(map.containsKey(key)) {
            List<Pair> alreadyList = map.get(key);
            alreadyList.add(pair);
            map.put(key, alreadyList);
        } else {
            List<Pair> newList = new ArrayList<>();
            newList.add(new Pair(timestamp, value));
            map.put(key, newList);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            List<Pair> list = map.get(key);
            String ans = "";
            
            int l = 0;
            int r = list.size() - 1;
            while(l <= r) {
                int mid = l + (r-l)/2;
                if(list.get(mid).timeStamp <= timestamp) {
                    ans = list.get(mid).value;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return ans;
        } else {
            return "";
        }
    }
}
