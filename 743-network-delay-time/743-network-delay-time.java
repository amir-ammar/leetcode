class Solution {
    static final int INF = (int)1e9;
    static ArrayList<Edge>[] adjList;
    static int V;


    static int dijkstra(int S, int T)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        dist[S] = 0;
        pq.add(new Edge(S, 0));
        while(!pq.isEmpty())
        {
            Edge cur = pq.remove();
            if(cur.node == T)
                return dist[T];
            if(cur.cost > dist[cur.node])
                continue;
            for(Edge nxt: adjList[cur.node])
                if(cur.cost + nxt.cost < dist[nxt.node])
                    pq.add(new Edge(nxt.node, dist[nxt.node] = cur.cost + nxt.cost ));
        }
        return -1;
    }


    static class Edge implements Comparable<Edge>
    {
        int node, cost;

        Edge(int a, int b) { node = a;	cost = b; }

        public int compareTo(Edge e){ return cost - e.cost;	}
    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        adjList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adjList[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < times.length; i++) {
            adjList[times[i][0]].add(new Edge(times[i][1], times[i][2]));
        }
        V = n+1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(i != k) {
                int dist = dijkstra(k, i);
                if(dist == -1)
                    return -1;
                ans = Math.max(ans, dist);
            }
        }


        return ans;
    }
}