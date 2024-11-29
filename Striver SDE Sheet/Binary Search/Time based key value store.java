class TimeMap {
    HashMap<String,TreeMap<Integer,String>>map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            TreeMap<Integer,String>timeMap = new TreeMap<>();
            timeMap.put(timestamp,value);
            map.put(key, timeMap);
        }else{
            TreeMap<Integer,String>timeMap = map.get(key);
            timeMap.put(timestamp,value);
            map.put(key, timeMap);
        }
    }
    
    public String get(String key, int timestamp) {
        String ans="";
        if(!map.containsKey(key)) 
            return ans;
        TreeMap<Integer,String>timeMap = map.get(key);
        if(timeMap.floorEntry(timestamp)!=null){
            ans = timeMap.floorEntry(timestamp).getValue();
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */