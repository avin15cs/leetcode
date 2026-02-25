class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Map<String, String> graph=new HashMap<>();
        // Set<String> dest = new HashSet<>();

        // for(List<String> ticket: tickets) {
        //     String src = ticket.get(0);
        //     String des = ticket.get(1);

        //     graph.put(src, des);
        //     dest.add(des);
        // }

        // String start = "";
        // for(String src: graph.keySet()) {
        //     if(!dest.contains(src)) {
        //         start = src;
        //         break;
        //     }
        // }

        // List<String> result = new ArrayList<>();

        // while(start!=null) {
        //     result.add(start);
        //     start=graph.get(start);
        // }

        // return result;

        Map<String,PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket: tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);

            if(!graph.containsKey(src)) {
                graph.put(src, new PriorityQueue<>());
            } 
            graph.get(src).add(dest);
        }
        List<String> result = new LinkedList<>();
        dfs("JFK", result, graph);

        return result;
    }

    void dfs(String airport, List<String> result, Map<String, PriorityQueue<String>> graph) {
        PriorityQueue<String> dest = graph.get(airport);

        while(dest!=null && !dest.isEmpty()) {
            String next = dest.remove();
            dfs(next, result, graph);
        }

        result.addFirst(airport);
    }
}