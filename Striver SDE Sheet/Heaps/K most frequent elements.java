class Solution {
    class Pair{
        int number;
        int frequency;
        Pair(int num, int freq){
            this.number = num;
            this.frequency = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        PriorityQueue<Pair>heap = new PriorityQueue<>((a,b)->b.frequency-a.frequency);
        map.forEach((key,value)->{
            heap.add(new Pair(key,value));
        });
        int[] ans = new int[k];
        for (int i = 0; i<k; i++) {
            ans[i] = heap.poll().number;
        }
        return ans;
    }
}