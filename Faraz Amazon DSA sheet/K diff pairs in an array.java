class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(k==0){
                if(map.get(nums[i])>1) count++;
            }
            else{
                if(map.containsKey(nums[i]+k)) count++;
            }
        }
        return count;
    }
}