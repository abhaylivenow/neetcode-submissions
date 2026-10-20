class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1 ; i >= 0 ; i--) {
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = Math.abs(i - stack.peek());
            }

            //System.out.print(i+",");
            stack.push(i);
        }

        return ans;
    }
}
