class Solution {
    static ArrayList<Edge>[] adjList;
    static int V;

    static int prim()		//O(E log E)
    {
        int mst = 0;
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(0, new point(0, 0), 0));
        while(!pq.isEmpty())
        {
            Edge cur = pq.remove();
            if(visited[cur.node])
                continue;
            visited[cur.node] = true;
            mst += cur.cost;
            for(Edge nxt: adjList[cur.node])
                if(!visited[nxt.node])
                    pq.add(nxt);
        }
        return mst;
    }


    static class point {
        int x, y;
        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>
    {

        point point;
        int node, cost;

        Edge(int node, point point, int cost) {
            this.node = node;
            this.point = point;
            this.cost = cost;
        }

        public int compareTo(Edge e) { return cost - e.cost; }

    }



    public static int cost (int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static int minCostConnectPoints(int[][] points) {
        V = points.length;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {

            for (int j = i+1; j < V; j++) {

                int cost = cost(points[i][0], points[i][1], points[j][0], points[j][1]);
                adjList[i].add(new Edge(j, new point(points[j][0], points[j][1]), cost));
                adjList[j].add(new Edge(i, new point(points[i][0], points[i][1]), cost));
            }

        }

        return prim();
    }
}