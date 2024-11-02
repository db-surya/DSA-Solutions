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
        if(head==null || head.next==null)
        return;
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        ListNode n1=head;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode n2=reverse(slow);
        head= merge(n1,n2);
    }
    ListNode merge(ListNode n1,ListNode n2)
    {
        ListNode ans=n1;
        while(n1!=null)
        {
            ListNode n1_next=n1.next;
            ListNode n2_next=n2.next;
            n1.next=n2;
            if(n1_next==null){
                return ans;
            }
            n2.next=n1_next;
            n1=n2.next;
            n2=n2_next;
        }
        return ans;
    }
    ListNode reverse(ListNode head)
    {
        ListNode reverse=null;
        ListNode temp=head;
        while(head!=null)
        {
            head=head.next;
            temp.next=reverse;
            reverse=temp;
            temp=head;
        }
        head=reverse;
        return head;
    }
}