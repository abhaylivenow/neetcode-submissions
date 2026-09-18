class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;

        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            String val = tokens[i];
            if(val.equals("+")) {
                int sum = 0;
                int ele1 = -1;
                int ele2 = -1;
                if(!stack.isEmpty()) {
                    ele1 = stack.pop();
                }
                if(!stack.isEmpty()) {
                    ele2 = stack.pop();
                }
                sum = ele1 + ele2;
                stack.push(sum);
            } else if(val.equals("*")) {
                int sum = 0;
                int ele1 = -1;
                int ele2 = -1;
                if(!stack.isEmpty()) {
                    ele1 = stack.pop();
                }
                if(!stack.isEmpty()) {
                    ele2 = stack.pop();
                }
                sum = ele1 * ele2;
                stack.push(sum);
            } else if(val.equals("-")) {
                int sum = 0;
                int ele1 = -1;
                int ele2 = -1;
                if(!stack.isEmpty()) {
                    ele1 = stack.pop();
                }
                if(!stack.isEmpty()) {
                    ele2 = stack.pop();
                }
                sum = ele2 - ele1;
                stack.push(sum);
            } else if(val.equals("/")) {
                int sum = 0;
                int ele1 = -1;
                int ele2 = -1;
                if(!stack.isEmpty()) {
                    ele1 = stack.pop();
                }
                if(!stack.isEmpty()) {
                    ele2 = stack.pop();
                }
                sum = ele2 / ele1;
                stack.push(sum);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
