class Solution {
    static ArrayList<Integer>[] realGraph;
    static ArrayList<Integer>[] fakeGraph;

    static boolean [] visited;


    public static int dfs(int v) {

        if (visited[v]) return 0;
        visited[v] = true;

        int res = 0;
        for (int i = 0; i < fakeGraph[v].size(); i++) {
            if (!realGraph[fakeGraph[v].get(i)].contains(v) && !visited[fakeGraph[v].get(i)]) {
                res += 1 + dfs(fakeGraph[v].get(i));
            } else {
                res += dfs(fakeGraph[v].get(i));
            }
        }
        return res;
    }

    public static int minReorder(int n, int[][] connections) {
        realGraph = new ArrayList[n];
        fakeGraph = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            fakeGraph[i] = new ArrayList<>();
            realGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.length; i++) {
            realGraph[connections[i][0]].add(connections[i][1]);
            fakeGraph[connections[i][0]].add(connections[i][1]);
            fakeGraph[connections[i][1]].add(connections[i][0]);
        }

        return dfs(0);
    }
}