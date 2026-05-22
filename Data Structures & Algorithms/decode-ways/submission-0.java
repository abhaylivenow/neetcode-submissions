class Solution {
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    public int numDecodings(String s) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(s.startsWith("0")) {
            return 0;
        }

        if(s.length() == 0) {
            return 1;
        }
        
        String s1 = s.substring(1, s.length());
        String s2 = null;
        if(s.length() > 1) {
            s2 = s.substring(0,2);
        }

        if((s2 != null) && Integer.parseInt(s2) <= 26 && (s2 != null && !s2.startsWith("0"))) {
            count = numDecodings(s1) + numDecodings(s.substring(2, s.length()));
            map.put(s, count);
        } else {
            count = numDecodings(s1);
            map.put(s, count);
        }

        return count;
    }
}
