class TimeMap {

    Map<String,List<Pair>> map;

    class Pair {
        String val;
        int time;
        Pair(int time, String val) {
            this.time=time;
            this.val=val;
        }
    }
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            List<Pair> list = new ArrayList<>();
            map.put(key,list);
        }
        Pair pair=new Pair(timestamp,value);
        map.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";

        List<Pair> plist = map.get(key);

        int l=0,r=plist.size()-1;
        String ans="";
        while(l<=r) {
            int mid=l+(r-l)/2;
            int time = plist.get(mid).time;
            if(time == timestamp)
                return plist.get(mid).val;
            else if(time<timestamp){
                ans=plist.get(mid).val;
                l=mid+1;
            } else {
                r=mid-1;
            }
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