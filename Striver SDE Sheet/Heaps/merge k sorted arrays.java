import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	static class Pair{
		int data;
		int index;
		int arrayIndex;
		Pair(int d, int i, int ai){
			this.data = d;
			this.index = i;
			this.arrayIndex = ai;
		}
	}
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Pair>heap = new PriorityQueue<>((a,b)->a.data-b.data);
		// Write your code here.
		for(int i=0;i<k;i++){
			heap.add(new Pair(kArrays.get(i).get(0),0,i));
		}
		ArrayList<Integer>ans = new ArrayList<>();
		while(!heap.isEmpty()){
			Pair curr = heap.poll();
			int currData = curr.data;
			int currIndex = curr.index;
			int currArrayIndex = curr.arrayIndex;
			ans.add(currData);
			if(currIndex+1 < kArrays.get(currArrayIndex).size()){
				heap.add(new Pair(kArrays.get(currArrayIndex).get(currIndex+1),currIndex+1,currArrayIndex));
			}
		}
		return ans;
	}
}
