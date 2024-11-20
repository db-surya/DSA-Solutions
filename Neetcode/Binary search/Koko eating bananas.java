class Solution {
    public int timeTaken(int[] piles, int hourly){
        int sum = 0;
        for(int i=0;i<piles.length;i++){
            sum+= Math.ceil((double)piles[i]/hourly);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int low = 1, high = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(timeTaken(piles,mid)<=h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}