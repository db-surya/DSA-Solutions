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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue <Integer> minheap = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode head=lists[i];
            while(head!=null)
            {
                minheap.add(head.val);
                head=head.next;
            }
        }
        ListNode dummy= new ListNode(0,null);
        ListNode head=dummy;
        while(!minheap.isEmpty())
        {
            ListNode temp= new ListNode(minheap.remove(),null);
            head.next=temp;
            head=head.next;
        }
        return dummy.next;
    }
}