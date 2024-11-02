class GfG
{
    Node flatten(Node head)
    {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        Node ans=new Node(0);
        Node result=ans;
        while(head!=null)
        {
            Node travel=head;
            while(travel!=null)
            {
                heap.add(travel.data);
                travel=travel.bottom;
            }
            head=head.next;
        }
        while(!heap.isEmpty())
        {
            Node temp=new Node(heap.remove());
            ans.bottom=temp;
            ans=ans.bottom;
        }
        return result.bottom;
    }
}