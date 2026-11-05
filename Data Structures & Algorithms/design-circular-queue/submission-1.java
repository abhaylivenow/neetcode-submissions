class MyCircularQueue {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int v) {
            val = v;
        }
    }

    ListNode front;
    ListNode rear;
    int capacity;

    public int getSize(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        size = size - 1;
        if(size < 0) {
            return 0;
        }
        return size;
    }

    public MyCircularQueue(int k) {
        front = new ListNode(-1);
        rear = new ListNode(-1);
        capacity = k;
        rear.next = front;
        front.prev = rear;
    }
    
    public boolean enQueue(int value) {
        if(getSize(rear.next) < capacity) {
            ListNode node = new ListNode(value);
            ListNode oldNext = rear.next;
            node.next = rear.next;
            node.prev = rear;
            rear.next = node;
            oldNext.prev = node;

            return true;
        }

        return false;
    }
    
    public boolean deQueue() {
        if(getSize(rear.next) <= 0) {
            return false;
        }
        // front.prev needs to be removed
        ListNode nodeToBeRemove = front.prev;

        ListNode prevNode = nodeToBeRemove.prev;
        front.prev = nodeToBeRemove.prev;
        prevNode.next = front;
        return true;
    }
    
    public int Front() {
        return front.prev.val;
    }
    
    public int Rear() {
        return rear.next.val;
    }
    
    public boolean isEmpty() {
        return getSize(rear.next) == 0;
    }
    
    public boolean isFull() {
        return getSize(rear.next) == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */