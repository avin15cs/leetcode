class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<Integer>> map = new HashMap<>();

        for(int i=0;i<keyName.length;i++) {
            if(!map.containsKey(keyName[i]))
                map.put(keyName[i],new ArrayList<>());

            map.get(keyName[i]).add(convertToMins(keyTime[i]));
        }
        List<String> result = new ArrayList<>();

        for(String name: map.keySet()) {
            List<Integer> times = map.get(name);

            Collections.sort(times);

            for(int i=0;i<times.size()-2;i++) {
                if(times.get(i+2)-times.get(i)<=60) {
                    result.add(name);
                    break;
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    private int convertToMins(String keyTime) {
        String[] str = keyTime.split(":");
        return Integer.valueOf(str[0])*60+Integer.valueOf(str[1]);
    }
}