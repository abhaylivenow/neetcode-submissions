class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strs.size() ; i++) {
            String curr = strs.get(i);
            int len = curr.length();
            sb.append(len+"#"+curr);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int pos = 0;
        int j = 0;
        while(pos < str.length()) {
            j = pos;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(pos, j));
            String s = str.substring(j+1, j+length+1);
            ans.add(s);
            pos = j+length+1;
        }
        return ans;
    }
}
