class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack();
        int n = arr.length;

        for(int i = 0 ; i < n ; i++) {
            if(!stack.isEmpty() && arr[i].equals("..")) {
                stack.pop();
            } else if(!arr[i].equals(".") && !arr[i].equals("") && !arr[i].equals("..")) {
                stack.push(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        if(sb.toString().equals("")) {
            return "/";
        }
        return sb.toString();
    }
}