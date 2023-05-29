package H332ReconstructItinerary;

import java.util.*;

public class Solution {
    /**
     * Time: O(E ^ d)
     * Space: O(V + E)
     */
    List<String> res = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(1);
            if (!adj.containsKey(from)) {
                adj.put(from, new ArrayList<>());
            }
            adj.get(from).add(to);
        }
        List<String> ls = new ArrayList<>();
        ls.add("JFK");
        dfs(adj, tickets.size(), ls, "JFK");
        return res;
    }

    private void dfs(Map<String, List<String>> adj, int n, List<String> ls, String curr) {
        if (res != null) {
            return;
        }
        if (n == 0) {
            res = new ArrayList<>(ls);
            return;
        }
        List<String> nei = adj.getOrDefault(curr, new ArrayList<>());
        Collections.sort(nei);
        for (int i = 0; i < nei.size(); i++) {
            String s = nei.get(i);
            ls.add(s);
            adj.get(curr).remove(i);
            dfs(adj, n - 1, ls , s);
            ls.remove(ls.size() - 1);
            adj.get(curr).add(0, s);
        }
    }


    /**
     * Time: O(E log (E / V))
     * Space: O(E + V)
     */
    // origin -> list of destinations
//    HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
//    LinkedList<String> result = null;
//
//    public List<String> findItinerary(List<List<String>> tickets) {
//        // Step 1). build the graph first
//        for(List<String> ticket : tickets) {
//            String origin = ticket.get(0);
//            String dest = ticket.get(1);
//            if (this.flightMap.containsKey(origin)) {
//                LinkedList<String> destList = this.flightMap.get(origin);
//                destList.add(dest);
//            } else {
//                LinkedList<String> destList = new LinkedList<String>();
//                destList.add(dest);
//                this.flightMap.put(origin, destList);
//            }
//        }
//
//        // Step 2). order the destinations
//        this.flightMap.forEach((key, value) -> Collections.sort(value));
//
//        this.result = new LinkedList<String>();
//        // Step 3). post-order DFS
//        this.DFS("JFK");
//        return this.result;
//    }
//
//    protected void DFS(String origin) {
//        // Visit all the outgoing edges first.
//        if (this.flightMap.containsKey(origin)) {
//            LinkedList<String> destList = this.flightMap.get(origin);
//            while (!destList.isEmpty()) {
//                // while we visit the edge, we trim it off from graph.
//                String dest = destList.pollFirst();
//                DFS(dest);
//            }
//        }
//        // add the airport to the head of the itinerary
//        this.result.offerFirst(origin);
//    }
}
