class MinStack {

    class Pair {
        int val;
        int min;

        public Pair(int v, int m) {
            val = v;
            min = m;
        }
    }

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int minSoFar = Integer.MAX_VALUE;
        if(stack.isEmpty()) {
            minSoFar = val;
        } else {
            minSoFar = Math.min(stack.peek().min, val);
        }
        stack.push(new Pair(val, minSoFar));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        Pair topElement = stack.peek();
        return topElement.min;
    }
}
