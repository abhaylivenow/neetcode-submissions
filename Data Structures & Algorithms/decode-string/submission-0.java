class Solution {
    int i = 0;
    public String decodeString(String s) {
        return dfs(s);
    }

    public String dfs(String s) {
        int n = s.length();
        
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                k = (k*10) + (ch - '0');
            } else if(ch == '[') {
                i++;
                String decode = dfs(s);
                for(int j = 0 ; j < k ; j++) {
                    sb.append(decode);
                }
                k = 0;
            } else if(ch == ']') {
                return sb.toString();
            } else {
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }
}