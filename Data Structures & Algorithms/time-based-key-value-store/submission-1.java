public class TimeMap {

    public Map<String, List<Pair>> map = null;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timeStamp) {
        //if key already exists get the pair list and add it, other wise create a new arraylist and create new Pair and add
        List<Pair> pairs = null;
        Pair pair = new Pair(timeStamp, value);
        if(map.containsKey(key)) {
            pairs = map.get(key);
            pairs.add(pair);
        } else {
            pairs = new ArrayList<>();
            pairs.add(pair);
        }
        map.put(key, pairs);
    }
    
    public String get(String key, int timestamp) {

        String defaulValue = "";
        if(map.containsKey(key)) {
            List<Pair> pairs = map.get(key);
        

            int l = 0;
            int r = pairs.size() - 1;
            while( l <= r) {
                int m = l + (r-l)/2;
                Pair p = pairs.get(m);
                if(p.getTimeStamp() == timestamp) {
                    return p.getValue();
                } else if(p.getTimeStamp() < timestamp) {
                    defaulValue = p.getValue();
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        
    return defaulValue;
        
    }
}

class Pair {

    private int timeStamp;
    private String value;

    public Pair(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public String getValue() {
        return this.value;
    }
}

