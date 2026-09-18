class MinStack {

    class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    Stack<Pair> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        stack.push(new Pair(val, min));
    }
    
    public void pop() {
        stack.pop();
        if(stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = stack.peek().second;
        }
    }
    
    public int top() {
        return stack.peek().first;
    }
    
    public int getMin() {
        return stack.peek().second;
    }
}
