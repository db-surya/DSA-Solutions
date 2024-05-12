public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer>map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j=0;
        while(j<A.size()){
            int jthValue = A.get(j);
            map.put(A.get(j), map.getOrDefault(jthValue,0)+1);
            if(j-i+1==B){
                ans.add(map.size());
                int ithValue = A.get(i);
                map.put((ithValue),map.get(ithValue)-1);
                if(map.get(ithValue)==0)
                map.remove(ithValue);
                i++;
            }
            j++;
        }
        return ans;
    }
}
