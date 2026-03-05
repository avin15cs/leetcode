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

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(!graph.containsKey(from)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                graph.put(from, pq);
            }
            graph.get(from).add(to);
        }
        List<String> result = new LinkedList<>();
        dfs(graph, result, "JFK");

        return result;
    }

    void dfs(Map<String, PriorityQueue<String>> graph, List<String> result, String from) {

        PriorityQueue<String> dests = graph.get(from);
        while(dests!=null && !dests.isEmpty()) {
                dfs(graph, result, dests.remove());
        }
        result.addFirst(from);
    }
}