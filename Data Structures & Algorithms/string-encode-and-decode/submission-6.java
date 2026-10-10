class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int len = s.length();
            sb.append(String.valueOf(len)+"#"+s);
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int n = str.length();
        int j = 0;
        int i = 0;
        while(j < n) {
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.valueOf(str.substring(i,j));
            String s = str.substring(j+1, j+1+len);
            ans.add(s);
            i = j+1+len;
            j = j+1+len;
        }
        return ans;
    }
}
