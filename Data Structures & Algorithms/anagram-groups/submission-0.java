class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String result = new String(charArray);

            if(map.containsKey(result)) {
                List<String> list = map.get(result);
                list.add(s);
                map.put(result, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(result, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        //int n = map.size();
        for(String key : map.keySet()) {
            List<String> list = map.get(key);
            ans.add(list);
        }
        return ans;
    }
}
