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
    public ListNode reverse(ListNode head)
    {
        ListNode reverse = null,temp = head;
        while(head!=null)
        {
            head = head.next;
            temp.next = reverse;
            reverse = temp;
            temp = head;
        }
        return reverse;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverse(slow);
        while(reverse!=null)
        {
            if(reverse.val!=head.val)
                return false;
            else
            {
                reverse = reverse.next;
                head = head.next;
            }
        }
        return true;
    }
}