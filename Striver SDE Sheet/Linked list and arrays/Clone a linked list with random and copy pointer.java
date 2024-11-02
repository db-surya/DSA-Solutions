/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node temp = head;
        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next =  newNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp!=null)
        {
            if(temp.random!=null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        Node temp1 = head;
        Node head2 = temp1.next,temp2 = head2;
        while(temp2!=null || temp1!=null)
        {
            if(temp1.next!=null)
                temp1.next = temp1.next.next;
            if(temp2.next!=null)
                temp2.next = temp2.next.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return head2;
    }
}