/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode entry = head, slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }
        if(fast == null || fast.next==null)
            return null;
        while(entry!=slow)
        {
            slow = slow.next;
            entry = entry.next;
        }
        return slow;
    }
}