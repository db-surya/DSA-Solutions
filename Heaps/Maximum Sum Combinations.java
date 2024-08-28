public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        Arrays.sort(A);
        Arrays.sort(B);
        int n1 = A.length, n2 = B.length;
        PriorityQueue<int[]>maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        HashSet<String>visited = new HashSet<>();
        maxHeap.add(new int[]{A[n1-1]+B[n2-1],n1-1,n2-1});
        visited.add((n1-1)+"-"+(n2-1));
        ArrayList<Integer>ans = new ArrayList<>();
        for(int iter=0;iter<C;iter++){
            int curr[] =  maxHeap.poll();
            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];
            ans.add(sum);
            if(i-1>=0 && !visited.contains((i-1)+"-"+(j))){
                maxHeap.add(new int[]{A[i-1]+B[j],i-1,j});
                visited.add(i-1+"-"+j);
            }
            if(j-1>=0 && !visited.contains(i+"-"+(j-1))){
                maxHeap.add(new int[]{A[i]+B[j-1],i,j-1});
                visited.add(i+"-"+(j-1));
            }
        }
        int[] result = new int[C];
        for (int k = 0; k < C; k++) {
            result[k] = ans.get(k);
        }
        return result;
    }
}