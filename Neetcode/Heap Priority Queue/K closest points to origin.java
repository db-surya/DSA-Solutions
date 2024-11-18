class Solution {
    class Pair{
        double distance;
        int[] arr;
        Pair(double _distance,int[] _arr){
            this.distance = _distance;
            this.arr = _arr;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>maxHeap = new PriorityQueue<>((a,b)->Double.compare(b.distance, a.distance));
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double euclideanDistance = Math.sqrt(Math.pow(x-0,2)+Math.pow(y-0,2));
            Pair p = new Pair(euclideanDistance, new int[]{x,y});
            maxHeap.add(p);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int ans[][] = new int[k][2];
        int count = 0;
        while(!maxHeap.isEmpty()){
            Pair currPair = maxHeap.poll();
            int curr[] = currPair.arr;
            ans[count][0] =  curr[0];
            ans[count][1] =  curr[1];
            count++;
        }
        return ans;
    }
}

//a.distance - b.distance cannot done on double because they may cause some irregularities
