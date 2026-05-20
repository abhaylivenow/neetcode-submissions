class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(s.equals("")){
            return true;
        }

        for(int i = 0 ; i < wordDict.size() ; i++) {
            if(s.startsWith(wordDict.get(i))) {
                String sub = s.substring(wordDict.get(i).length());
                boolean ans = wordBreak(sub, wordDict);
                if(ans == true) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
