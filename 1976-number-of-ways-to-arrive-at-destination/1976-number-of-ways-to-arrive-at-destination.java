public class Solution {

    static final int INF = (int)1e9;	
    static ArrayList<Edge>[] adjList;
    static int V;
    static long [] ways;
    static int MOD = (int)(1e9 + 7);


    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        Edge(int a, int b) { node = a;	cost = b; }

        public int compareTo(Edge e){ return (int) (cost - e.cost);	}

        public String toString() { return node + " " + cost; }

    }

    public static int countPaths(int n, int[][] roads) {

        V = n;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adjList[i] = new ArrayList<>();

        ways = new long[V];
        ways[0] = 1;
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        dijkstra(0, n-1);
        return (int)ways[n-1];

    }

    public static int dijkstra(int S, int T)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[S] = 0;
        pq.add(new Edge(S, 0));
        while(!pq.isEmpty())
        {
            Edge cur = pq.remove();
            if(cur.node == T)
                return dist[T];
            if(cur.cost > dist[cur.node])
                continue;
            for(Edge nxt: adjList[cur.node]) {
                if (cur.cost + nxt.cost < dist[nxt.node]) {
                    pq.add(new Edge(nxt.node, dist[nxt.node] = (int) (cur.cost + nxt.cost)));
                    ways[nxt.node] = ways[cur.node];
                } else if(dist[nxt.node] == cur.cost + nxt.cost) {
                    ways[nxt.node] = (ways[cur.node] + ways[nxt.node]) % MOD;
                }
            }
        }
        return -1;
    }

}
