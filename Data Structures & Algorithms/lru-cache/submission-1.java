class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    ListNode head;
    ListNode tail;

    int capacity;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            //map.put(key, new ListNode(key, value));
            moveToHead(node);
        } else {
            if(map.size() >= capacity) {
                ListNode nodeToDelete = tail.prev;
                deleteNode(nodeToDelete);
                map.remove(nodeToDelete.key);
            }
            ListNode node = new ListNode(key, value);
            addToHead(node);
            map.put(key, node);
        }
    }

    public void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(ListNode node) {
        // insert a node between head and head.next;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(ListNode node) {
        deleteNode(node);
        addToHead(node);
    }
}
