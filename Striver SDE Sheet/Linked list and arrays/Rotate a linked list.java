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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            if(temp.next==null){
                temp.next = head;
                break;
            }
            temp=temp.next;
        }
        int iterations = k%count;
        for(int i=0;i<count-iterations;i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}