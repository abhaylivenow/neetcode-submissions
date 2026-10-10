class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String result = getResult(s);

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
        for(String key : map.keySet()) {
            List<String> list = map.get(key);
            ans.add(list);
        }
        return ans;
    }

    public String getResult(String s) {
        int[] num = new int[26];
        int n = s.length();
        for(int i = 0 ; i < n ; i++) {
            char c = s.charAt(i);
            num[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 26 ; i++) {
            if(num[i] != 0) {
                // nums[i] -> no of times that character
                // i -> character
                StringBuilder sb1 = new StringBuilder();
                char c = (char)('a' + i);
                for(int j = 0 ; j < num[i] ; j++) {
                    sb1.append(String.valueOf(c));
                }
                sb.append(sb1.toString());
            }
        }

        return sb.toString();
    }
}
