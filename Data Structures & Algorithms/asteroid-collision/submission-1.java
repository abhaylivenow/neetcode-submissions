class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> stack = new Stack<>();
        int n = ast.length;

        for(int i = 0 ; i < n ; i++) {
            if(ast[i] < 0) {
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(ast[i]) > stack.peek()) {
                    stack.pop();
                }

                if(!stack.isEmpty() && Math.abs(ast[i]) == stack.peek()) {
                    stack.pop();
                } else if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ast[i]);
                }
            } else {
                stack.push(ast[i]);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = ans.length-1 ; i >= 0 ; i--) {
            ans[i] = stack.peek();
            stack.pop();
        }
        return ans;
    }
}