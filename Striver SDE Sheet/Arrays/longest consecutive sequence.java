class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        int maxCount = 0;
        for(int num:nums)
            set.add(num);
        for(int num:nums)
        {
            int count = 1;
            if(!set.contains(num-1))
            {
                while(set.contains(++num))
                    count++;
                maxCount = Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}