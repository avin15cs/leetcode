class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();

        for(String domain: cpdomains) {
            String[] parts = domain.split(" ");
            int count = Integer.parseInt(parts[0]);

            String[] domains = parts[1].split("\\.");

            String current = "";
            for(int i=domains.length-1;i>=0;i--) {
                if(current.isEmpty())
                    current = domains[i];
                else
                    current=domains[i]+"."+current;

                map.put(current, map.getOrDefault(current,0)+count);
            }
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: map.entrySet())
            result.add(entry.getValue() +" "+ entry.getKey());
        
        return result;
    }
}