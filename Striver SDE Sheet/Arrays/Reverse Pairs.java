class Solution {
    public int merge(int[] nums, int low, int mid, int high, int count){
        int l = low, r = mid+1;
        List<Integer>temp = new ArrayList<>();
        while(l<=mid && r<=high){
            if(nums[l]<=nums[r]){
                temp.add(nums[l]);
                l++;
            }
            else{
                temp.add(nums[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(nums[l++]);
        }
        while(r<=high){
            temp.add(nums[r++]);
        }
        for(int i=low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
        return count;
    }
    public int countPairs(int[] nums, int low, int mid, int high){
        int r = mid+1;
        int count = 0;
        for(int i=low;i<=mid;i++){
            while(r<=high && nums[i]>((long)2*nums[r])) r++;
            count+= r-(mid+1);
        }
        return count;
    }
    public int mergeSort(int[]nums, int low, int high){
        int count = 0;
        if(low==high) return count;
        int mid = (low+high)/2;
        count+= mergeSort(nums,low,mid);
        count+= mergeSort(nums,mid+1,high);
        count+= countPairs(nums,low,mid,high);
        merge(nums,low,mid,high,count);
        return count;
    }
    public int reversePairs(int[] nums) {
        int ans = mergeSort(nums,0,nums.length-1);
        return ans;
    }
}