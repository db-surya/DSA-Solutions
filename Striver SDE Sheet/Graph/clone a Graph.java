class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        LinkedList<Node>queue = new LinkedList<>();
        queue.add(node);
        HashMap<Node,Node>map = new HashMap<>();
        Node clone = new Node(node.val);
        map.put(node,clone);
        while(!queue.isEmpty()){
            Node current = queue.remove();
            for(int i=0;i<current.neighbors.size();i++){
                Node child = current.neighbors.get(i);
                if(!map.containsKey(child)){
                    map.put(child,new Node(child.val));
                    queue.add(child);
                }
                map.get(current).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
}
