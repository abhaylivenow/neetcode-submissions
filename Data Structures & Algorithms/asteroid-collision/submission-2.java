class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            if(ast[i] < 0) {
                while(!stack.isEmpty() && stack.peek() > 0 && ast[i] < 0 && Math.abs(ast[i]) > stack.peek()) {
                    stack.pop();
                }
                if(!stack.isEmpty() && Math.abs(ast[i]) == stack.peek()) {
                    stack.pop();
                } else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(ast[i]);
                }
            } else {
                stack.push(ast[i]);
            }
            
        }
        int size = stack.size();
        int[] ans = new int[size];
        int i = 0;

        for(int item : stack) {
            ans[i] = item;
            //stack.peek();
            i++;
        }
        return ans;
    }
}