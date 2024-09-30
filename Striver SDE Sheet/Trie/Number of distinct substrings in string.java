
import java.util.ArrayList;

public class Solution 
{
	static class Node{
		Node[] links;
		Node(){
			links = new Node[26];
		}
		Boolean containsKey(char ch){
			return links[ch-'a']!=null;
		}
		void put(char ch, Node node){
			links[ch-'a']=node;
		}
		Node get(char ch){
			return links[ch-'a'];
		}
	}
	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		Node root  = new Node();
		int count = 1;
		for(int i=0;i<s.length();i++){
			Node node = root;
			for(int j=i;j<s.length();j++){
				if(!node.containsKey(s.charAt(j))){
					node.put(s.charAt(j),new Node());
					count++;
				}
				node = node.get(s.charAt(j));
			}
		}
		return count;
	}
}