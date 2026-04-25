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
        int length = 0;
        while(pos < str.length()) {
            int j = pos;
            while(str.charAt(j)!='#')
                j++;
            // System.out.println(str.substring(pos, j));
            length = Integer.parseInt(str.substring(pos, j));
            // System.out.println("--- " + str.substring(j+1, j+length+1));
            String s = str.substring(j+1, j+length+1);
            ans.add(s);
            pos = j+length+1;
        }
        return ans;
    }
}
