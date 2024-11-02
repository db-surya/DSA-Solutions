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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode dummy = head;        
        int carry = 0;
        while(l1!=null || l2!=null)
        {
            int sum = 0;
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            int currentSum = sum+carry;
            ListNode currentNode = new ListNode(currentSum%10);
            carry = currentSum/10;
            head.next = currentNode;
            head = head.next;
        }
        if(carry>0)
        {
            ListNode first = new ListNode(carry);
            head.next = first;
        }
        return dummy.next;
    }
}