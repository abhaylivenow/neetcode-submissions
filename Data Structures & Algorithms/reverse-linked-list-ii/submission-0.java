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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;

        int counter = 1;
        while(counter < left) {
            leftPrev = curr;
            curr = curr.next;
            counter++;
        }

        int n = right - left + 1;
        ListNode leftCurr = curr;
        ListNode prev = null;
        for(int i = 1 ; i <= n ; i++) {
            ListNode nextNode = leftCurr.next;
            leftCurr.next = prev;
            prev = leftCurr;
            leftCurr = nextNode;
        }

        leftPrev.next = prev;
        curr.next = leftCurr;

        return dummy.next;
    }
}