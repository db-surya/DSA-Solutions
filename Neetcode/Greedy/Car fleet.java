class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer,Double>timeMap = new HashMap<>();
        for(int i=0;i<position.length;i++){
            double timeTaken = (double)(target-position[i])/speed[i];
            timeMap.put(position[i], timeTaken);
            //All position values are unique so collision is not possible
        }
        Arrays.sort(position);
        int index = position.length-1;
        int fleet = position.length;
        while(index>0){
            double curr = timeMap.get(position[index]);
            while(index>0 && curr>=(double)timeMap.get(position[index-1])){
                fleet--;
                index--;
            }
            index--;
        }
        return fleet;
    }
}