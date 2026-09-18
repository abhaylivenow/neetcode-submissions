class StockSpanner {

    class Pair {
        int curr;
        int span;

        public Pair(int c, int s) {
            curr = c;
            span = s;
        }
    }

    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && price >= stack.peek().curr) {
            span += stack.pop().span;
        }
            
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */