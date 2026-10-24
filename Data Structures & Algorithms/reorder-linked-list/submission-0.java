/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;

        int n = 0;
        while(curr != null) {
            curr = curr.next;
            n++;
        }
        curr = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedList = reverse(slow.next, n);
        slow.next = null;
        
        ListNode revListhead = reversedList;
        
        while(revListhead != null) {
            ListNode nextNode = curr.next;
            ListNode nextRevNode = revListhead.next;
            curr.next = revListhead;
            revListhead.next = nextNode;
            curr = nextNode;
            revListhead = nextRevNode;
        }
    }

    public ListNode reverse(ListNode startNode, int n) {
        // if(n % 2 != 0) {
        //     startNode = startNode.next;
        // }
        ListNode curr = startNode;
        ListNode prev = null;

        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
