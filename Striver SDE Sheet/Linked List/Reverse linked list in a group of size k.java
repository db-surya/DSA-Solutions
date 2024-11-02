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
        ListNode reverse = null, temp = head;
        while(head!=null)
        {
            head = head.next;
            temp.next = reverse;
            reverse = temp;
            temp = head;
        }
        return reverse;
    }
    public ListNode findKthNode(ListNode temp, int k)
    {
        while(k>1 && temp!=null)
        {
            temp =  temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevNode = null, nextNode = null;
        while(temp!=null)
        {
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null){
                if(prevNode!=null)
                    prevNode.next = nextNode;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverse(temp);
            if(prevNode!=null)
                prevNode.next = newHead;
            if(temp==head)
                head = newHead;
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}